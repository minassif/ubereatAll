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

import ubereat.model.Article;
import ubereat.model.Commande;
import ubereat.model.Views;
import ubereat.repository.IArticle;
import ubereat.repository.ICommande;


@RestController
@RequestMapping("/commande")
@CrossOrigin("*")
public class CommandeRestController {
	
		@Autowired
		private ICommande commandeRepo;
		@Autowired
		private IArticle articleRepo;

		@GetMapping("")
		@JsonView(Views.ViewCommande.class)
		public List<Commande> findAll() {
			List<Commande> commandes = commandeRepo.findAll();

			return commandes;
		}
		
		@GetMapping("Status/{status}")
		@JsonView(Views.ViewCommande.class)
		public List<Commande> findAllWithStatus(@PathVariable String status) {
			List<Commande> commandes = commandeRepo.findAllWithStatus(status);

			return commandes;
		}
		

		@GetMapping("Add/{id,idArticle}")
		@JsonView(Views.ViewCommandeDetail.class)
		public Commande add(@PathVariable Long id,@PathVariable Long idArticle) {
			Optional<Commande> optCommande = commandeRepo.findById(id);
			Optional<Article> optArticle = articleRepo.findById(idArticle);

			if (optCommande.isPresent()) {
				if (optArticle.isPresent()) {
					List<Article> list=optCommande.get().getArticles();
					list.add(optArticle.get());
					optCommande.get().setArticles(list);
				}
				return optCommande.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOPE");
			}
		}

		@GetMapping("Delete/{id,idArticle}")
		@JsonView(Views.ViewCommandeDetail.class)
		public Commande delete(@PathVariable Long id,@PathVariable Long idArticle) {
			Optional<Commande> optCommande = commandeRepo.findById(id);
			Optional<Article> optArticle = articleRepo.findById(idArticle);

			if (optCommande.isPresent()) {
				if (optArticle.isPresent()) {
					List<Article> list=optCommande.get().getArticles();
					list.remove(optArticle.get());
					optCommande.get().setArticles(list);
				}
				return optCommande.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOPE");
			}
		}
		
		@GetMapping("/livreur/{id}")
		@JsonView(Views.ViewCommande.class)
		public List<Commande> findAllByLivreur(@PathVariable Long id) {
			List<Commande> commandes = commandeRepo.findAllByLivreur(id);

			return commandes;
		}
		
		@GetMapping("/client/{id}")
		@JsonView(Views.ViewCommande.class)
		public List<Commande> findAllByClient(@PathVariable Long id) {
			List<Commande> commandes = commandeRepo.findAllByClient(id);

			return commandes;
		}
		
//		@GetMapping("/restaurant/{id}")
//		@JsonView(Views.ViewCommande.class)
//		public List<Commande> findAllByRestaurant(@PathVariable Long id) {
//			List<Commande> commandes = commandeRepo.findAllByRestaurant(id);
//
//			return commandes;
//		}


		@PostMapping("")
		@JsonView(Views.ViewCommandeDetail.class)
		public Commande create(@RequestBody Commande commande) {
			commande = commandeRepo.save(commande);

			return commande;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewCommandeDetail.class)
		public Commande update(@PathVariable Long id, @RequestBody Commande commande) {
			if (!commandeRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande non trouvé");
			}

			commande = commandeRepo.save(commande);

			return commande;
		}

		
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			if (!commandeRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande non trouvé");
			}
			
			commandeRepo.deleteById(id);
		}

}
