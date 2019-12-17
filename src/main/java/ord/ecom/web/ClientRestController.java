package ord.ecom.web;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ord.ecom.dao.ClientRepository;
import ord.ecom.entities.Client;

@CrossOrigin("*")
@RestController
public class ClientRestController {
	private ClientRepository clientRepository;
	
	public ClientRestController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@GetMapping(value = "/clients")
	public List<Client> getClients() {
		return clientRepository.findAll();	
	}
	
	@GetMapping(value = "/clients/{idClient}")
	public Optional<Client> findById(@PathVariable(value="idClient") Long idClient) {
		return clientRepository.findById(idClient);

	}
	
	@PostMapping(path = "/clients/new-client}")
	public Client addClient(@RequestBody Client client) {
		return clientRepository.save(client);
		
	}
	
	@PutMapping(path = "/clients/update-client}")
	public Client putClient(@PathVariable("id") Long id, @RequestBody Client client) {
		
		return clientRepository.save(client);
		
	}
	
	@DeleteMapping(value = "/clients/{idClient}")
	public ResponseEntity<Object> deleteClient(@PathVariable(value="idClient") Long idClient) {
		clientRepository.deleteById(idClient);
		return ResponseEntity.ok().build();
	}
	
}
