package ubereat.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import ubereat.model.TypeResto;
import ubereat.model.Views;
import ubereat.repository.ITypeResto;

@RestController
@RequestMapping("/typeResto")
@CrossOrigin("*")
public class TypeRestoRestController {



	@Autowired
	private ITypeResto TypeRestoRepo;

	@GetMapping("")
	@JsonView(Views.ViewTypeResto.class)
	public List<TypeResto> findAll() {
		List<TypeResto> TypeRestos = TypeRestoRepo.findAll();

		return TypeRestos;
	}



	@GetMapping("{id}")
	@JsonView(Views.ViewTypeResto.class)
	public TypeResto find(@PathVariable Long id) {
		Optional<TypeResto> optTypeResto = TypeRestoRepo.findById(id);

		if (optTypeResto.isPresent()) {
			return optTypeResto.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeResto non trouvé");
		}
	}
	
	@GetMapping("/Like{String}")
	@JsonView(Views.ViewTypeResto.class)
	public List<TypeResto> findByName(@PathVariable String nom) {
		List<TypeResto> optTypeResto = TypeRestoRepo.findByName(nom);

		if (!optTypeResto.isEmpty()) {
			return optTypeResto;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeResto non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewTypeResto.class)
	public TypeResto create(@Valid @RequestBody TypeResto TypeResto, BindingResult result) {


		TypeResto = TypeRestoRepo.save(TypeResto);

		return TypeResto;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewTypeResto.class)
	public TypeResto update(@PathVariable Long id, @RequestBody TypeResto TypeResto) {
		if (!TypeRestoRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeResto non trouvé");
		}

		TypeResto = TypeRestoRepo.save(TypeResto);

		return TypeResto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!TypeRestoRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeResto non trouvé");
		}

		TypeRestoRepo.deleteById(id);
	}

}


