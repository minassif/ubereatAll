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

import ubereat.model.TypePlat;
import ubereat.model.TypeResto;
import ubereat.model.Views;
import ubereat.repository.ITypePlat;

@RestController
@RequestMapping("/TypePlat")
@CrossOrigin("*")
public class TypePlatRestController {
	
	

		@Autowired
		private ITypePlat TypePlatRepo;

		@GetMapping("")
		@JsonView(Views.ViewTypePlat.class)
		public List<TypePlat> findAll() {
			List<TypePlat> TypePlats = TypePlatRepo.findAll();

			return TypePlats;
		}
		
		

		@GetMapping("{id}")
		@JsonView(Views.ViewTypePlat.class)
		public TypePlat find(@PathVariable Long id) {
			Optional<TypePlat> optTypePlat = TypePlatRepo.findById(id);

			if (optTypePlat.isPresent()) {
				return optTypePlat.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypePlat non trouvé");
			}
		}
		
		@GetMapping("/Like{String}")
		@JsonView(Views.ViewTypePlat.class)
		public List<TypePlat> findByName(@PathVariable String nom) {
			List<TypePlat> optTypeResto = TypePlatRepo.findByName(nom);

			if (!optTypeResto.isEmpty()) {
				return optTypeResto;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeResto non trouvé");
			}
		}

		@PostMapping("")
		@JsonView(Views.ViewTypePlat.class)
		public TypePlat create(@Valid @RequestBody TypePlat TypePlat, BindingResult result) {
			
			
			TypePlat = TypePlatRepo.save(TypePlat);

			return TypePlat;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewTypePlat.class)
		public TypePlat update(@PathVariable Long id, @RequestBody TypePlat TypePlat) {
			if (!TypePlatRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypePlat non trouvé");
			}

			TypePlat = TypePlatRepo.save(TypePlat);

			return TypePlat;
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			if (!TypePlatRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypePlat non trouvé");
			}
			
			TypePlatRepo.deleteById(id);
		}

}


