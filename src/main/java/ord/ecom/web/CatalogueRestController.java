package ord.ecom.web;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ord.ecom.dao.ProductRepository;
import ord.ecom.entities.Product;

@RestController
@CrossOrigin("*")
public class CatalogueRestController {
	private ProductRepository productRepository;

	public CatalogueRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// methode pour afficher la photo d'un produit
	@GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
		Product p = productRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
	}
	// methode pour charger une photo
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {
		Product p = productRepository.findById(id).get();
		//p.setPhotoName(id+".png"); pr récupérer la photo par son id
		p.setPhotoName(file.getOriginalFilename()); // prmet de récupérer la photo par son nom d'origine
		Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
		productRepository.save(p);
		
	}

}
