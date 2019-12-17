package ord.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ord.ecom.entities.Payement;

@CrossOrigin("*")
@RepositoryRestResource
public interface PayementRepository extends JpaRepository<Payement, Long> {

}
