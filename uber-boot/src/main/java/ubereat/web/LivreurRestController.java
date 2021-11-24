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

import ubereat.model.Livreur;
import ubereat.model.Views;
import ubereat.repository.ILivreur;

@RestController
@RequestMapping("/livreur")
@CrossOrigin("*")

public class LivreurRestController {

	

	@Autowired
	private ILivreur livreurRepo;

	@GetMapping("")
	@JsonView(Views.ViewLivreur.class)
	public List<Livreur> findAll() {
		List<Livreur> livreurs = livreurRepo.findAll();

		return livreurs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewLivreur.class)
	public Livreur find(@PathVariable Long id) {
		Optional<Livreur> optLivreur = livreurRepo.findById(id);

		if (optLivreur.isPresent()) {
			return optLivreur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
	}


	@PostMapping("")
	@JsonView(Views.ViewEvaluation.class)
	public Livreur create(@RequestBody Livreur livreur) {
		livreur = livreurRepo.save(livreur);

		return livreur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLivreur.class)
	public Livreur update(@PathVariable Long id, @RequestBody Livreur livreur) {
		if (!livreurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		livreur = livreurRepo.save(livreur);

		return livreur;
	}

	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!livreurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		livreurRepo.deleteById(id);
	}
}
