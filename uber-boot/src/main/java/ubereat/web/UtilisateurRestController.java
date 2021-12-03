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

import ubereat.model.Utilisateur;
import ubereat.model.Views;
import ubereat.repository.IClient;
import ubereat.repository.ILivreur;
import ubereat.repository.IRestaurateur;
import ubereat.repository.IUtilisateur;
import ubereat.web.dto.ConnectDTO;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {
	
	

		@Autowired
		private IUtilisateur UtilisateurRepo;
		@Autowired
		private IClient ClientRepo;
		@Autowired
		private IRestaurateur RestaurateurRepo;
		@Autowired
		private ILivreur LivreurRepo;

		@GetMapping("")
		@JsonView(Views.ViewUtilisateur.class)
		public List<Utilisateur> findAll() {
			List<Utilisateur> Utilisateurs = UtilisateurRepo.findAll();

			return Utilisateurs;
		}
		
		

		@GetMapping("{id}")
		@JsonView(Views.ViewUtilisateur.class)
		public Utilisateur find(@PathVariable Long id) {
			Optional<Utilisateur> optUtilisateur = UtilisateurRepo.findById(id);

			if (optUtilisateur.isPresent()) {
				return optUtilisateur.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
			}
		}

		@PostMapping("")
		@JsonView(Views.ViewUtilisateur.class)
		public Utilisateur create(@Valid @RequestBody Utilisateur Utilisateur, BindingResult result) {
			
			
			Utilisateur = UtilisateurRepo.save(Utilisateur);

			return Utilisateur;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewUtilisateur.class)
		public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur Utilisateur) {
			if (!UtilisateurRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
			}

			Utilisateur = UtilisateurRepo.save(Utilisateur);

			return Utilisateur;
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			if (!UtilisateurRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
			}
			
			UtilisateurRepo.deleteById(id);
		}
		
		@PostMapping("/connect")
		@JsonView(Views.ViewUtilisateur.class)
		public Utilisateur connexion(@RequestBody ConnectDTO connect) {
			
			Optional<Utilisateur> optUtilisateur = UtilisateurRepo.findByUsernameAndPassword(connect.getEmail(),connect.getPassword());

			Utilisateur user;
			if (optUtilisateur.isPresent()) {
				user=optUtilisateur.get();
				if (ClientRepo.existsById(user.getId())) {
					user.setStatut("client");
				}
				if (RestaurateurRepo.existsById(user.getId())) {
					user.setStatut("restaurateur");
				}
				if (LivreurRepo.existsById(user.getId())) {
					user.setStatut("livreur");
				}
				
				return user;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
			}
		}

}




