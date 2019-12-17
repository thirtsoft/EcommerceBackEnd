package ord.ecom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String photo;
	 private String description;
	 @OneToMany(mappedBy = "category")
	 private Collection<Product> products;

}
