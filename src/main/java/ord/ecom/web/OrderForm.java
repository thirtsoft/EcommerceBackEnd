package ord.ecom.web;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import ord.ecom.entities.Client;

@Data
public class OrderForm {
	private Client client = new Client();
	private List<OrderProduct> products = new ArrayList<>();

}

@Data
class OrderProduct {
	private Long id;
	private int quantity;
}
