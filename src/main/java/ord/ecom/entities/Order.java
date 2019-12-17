package ord.ecom.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7286286461584199599L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> orderItems;
    @ManyToOne
    private Client client;
    private double totalAmount;
    @OneToOne
    private Payement payment;
	

}
