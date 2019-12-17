package ord.ecom;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ord.ecom.entities.Category;
import ord.ecom.entities.Product;

@SpringBootApplication
public class EcommerceBackEndApplication implements CommandLineRunner {
	
	// @Autowired private CategoryRepository categoryRepository;
	  
  //	@Autowired private ProductRepository productRepository; // configure spring
	 // rest pour pouvoir exposer les id sous format json
	  
	 @Autowired private RepositoryRestConfiguration repositoryRestConfiguration;
	 
	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// permet d'exposer les id de product et category
		repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
		
		
		/*
		 * categoryRepository.save(new Category(null,"Computer",null,null,null));
		 * categoryRepository.save(new Category(null,"Printer",null,null,null));
		 * categoryRepository.save(new Category(null,"Smart Phone",null,null,null));
		 * Random rnd = new Random(); categoryRepository.findAll().forEach(c-> { for
		 * (int i =0; i < 10; i++) { Product p = new Product();
		 * p.setName(RandomString.make(18)); p.setDescription(null);
		 * p.setCurrentPrice(100+rnd.nextInt(10000)); p.setPromotion(rnd.nextBoolean());
		 * p.setAvailable(rnd.nextBoolean()); p.setSelected(rnd.nextBoolean());
		 * p.setCategory(c); p.setPhotoName("unknown.png"); productRepository.save(p);
		 * 
		 * }
		 * 
		 * 
		 * });
		 */
		 
	}

}
