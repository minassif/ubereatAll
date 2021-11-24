package ubereat.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import ubereat.model.Client;
import ubereat.repository.IClient;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientRestController {
	
	@Autowired
	private IClient clientRepo;
	
	
	

	@GetMapping("")
	public List<Client> findAll() {
		List<Client> clients = clientRepo.findAll();
		return clients;
	}
	
	
	@GetMapping("{id}")
	public Client find(@PathVariable Long id) {
		Optional<Client> optClient = clientRepo.findById(id);

		if (optClient.isPresent()) {
			return optClient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé");
		}
	}
	
	@PostMapping("")

	public Client create(@RequestBody Client client) {
		client = clientRepo.save(client);

		return client;
	}
	
	
	@PutMapping("/{id}")

	public Client update(@PathVariable Long id, @RequestBody Client client) {
		if (!clientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé");
		}

		client = clientRepo.save(client);

		return client;
	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!clientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client non trouvé");
		}
		
		clientRepo.deleteById(id);
	}
	
	
}
