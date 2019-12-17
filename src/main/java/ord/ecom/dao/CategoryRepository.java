package ord.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ord.ecom.entities.Category;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
