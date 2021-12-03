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

import com.fasterxml.jackson.annotation.JsonView;

import ubereat.model.Restaurateur;
import ubereat.model.Views;
import ubereat.repository.IRestaurateur;

@RestController
@RequestMapping("/restaurateur")
@CrossOrigin("*")
public class RestaurateurRestController {
	@Autowired
	private IRestaurateur restaurateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewRestaurateur.class)
	public List<Restaurateur> findAll() {
		List<Restaurateur> restaurateurs = restaurateurRepo.findAll();

		return restaurateurs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewRestaurateur.class)
	public Restaurateur find(@PathVariable Long id) {
		Optional<Restaurateur> optRestaurateur = restaurateurRepo.findById(id);

		if (optRestaurateur.isPresent()) {
			return optRestaurateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
	}
	



	@PostMapping("")
	@JsonView(Views.ViewRestaurateur.class)
	public Restaurateur create(@RequestBody Restaurateur Restaurateur) {
		Restaurateur = restaurateurRepo.save(Restaurateur);

		return Restaurateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewRestaurateur.class)
	public Restaurateur update(@PathVariable Long id, @RequestBody Restaurateur restaurateur) {
		if (!restaurateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		restaurateur = restaurateurRepo.save(restaurateur);

		return restaurateur;
	}

	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!restaurateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		restaurateurRepo.deleteById(id);
	}
}
