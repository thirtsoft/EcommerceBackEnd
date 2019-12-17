package ord.ecom.web;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ord.ecom.dao.ClientRepository;
import ord.ecom.dao.OrderItemRepository;
import ord.ecom.dao.OrderRepository;
import ord.ecom.dao.ProductRepository;
import ord.ecom.entities.Client;
import ord.ecom.entities.Order;
import ord.ecom.entities.OrderItem;
import ord.ecom.entities.Product;

@CrossOrigin("*")
@RestController
public class OrderController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@PostMapping("/orders")
	public Order saveOrder(@RequestBody OrderForm orderForm) {
		Client client = new Client();
		client.setNomClient(orderForm.getClient().getNomClient());
		client.setPrenomClient(orderForm.getClient().getPrenomClient());
		client.setAddresseClient(orderForm.getClient().getAddresseClient());
		client.setTelClient(orderForm.getClient().getTelClient());
		client.setMailClient(orderForm.getClient().getMailClient());
		client.setUsername(orderForm.getClient().getUsername());
		client = clientRepository.save(client);
		System.out.println(client.getId());
		
		Order order = new Order();
		order.setClient(client);
		order.setDate(new Date());
		order = orderRepository.save(order);
		
		double total = 0;
		for(OrderProduct p : orderForm.getProducts()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			Product product = productRepository.findById(p.getId()).get();
			orderItem.setProduct(product);
			orderItem.setPrice(product.getCurrentPrice());
			orderItem.setQuantity(p.getQuantity());
			orderItemRepository.save(orderItem);
			total+=p.getQuantity()*product.getCurrentPrice();
		}
		order.setTotalAmount(total);
		return orderRepository.save(order);
		
	}
	
	@GetMapping(value = "/orders/{id}")
	public Optional<Order> findById(@PathVariable("id") Long id) {
		return orderRepository.findById(id);

	}

}
