package ord.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ord.ecom.entities.Product;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	
   // methode pour afficher les produits selectionnées
	@RestResource(path = "/selectedProducts")
	public List<Product> findBySelectedIsTrue();
	
	// methode1 pour chercher un produit par mot clé
	/*@RestResource(path = "/productsByKeyword")
	@Query("select p from Product p where p.name like :x")
	public List<Product> chercher(@Param("x") String mc);*/
	
	// methode2 pour chercher un produit par mot clé
	@RestResource(path = "/productsByKeyword")
	public List<Product> findByNameContains(@Param("mc") String mc);
	
	// methode pour afficher les produits en promo 
	@RestResource(path = "/promoProducts")
	public List<Product> findByPromotionIsTrue();
		
	// methode pour afficher les produits disponibles available
	@RestResource(path = "/dispoProducts")
	public List<Product> findByAvailableIsTrue();

}
