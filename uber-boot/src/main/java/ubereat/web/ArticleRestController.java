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
import ubereat.model.TypesPlats;
import ubereat.model.Views;
import ubereat.repository.IArticle;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleRestController {
	
	
	@Autowired
	private IArticle articleRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewArticle.class)
	public List<Article> findAll() {
		List<Article> articles = articleRepo.findAll();

		return articles;
	}
	
	@GetMapping("/prixAsc")
	@JsonView(Views.ViewArticlePrixAsc.class)
	public List<Article> findAllByPrixAsc() {
		List<Article> articles = articleRepo.findAllByPrixAsc();

		return articles;
	}
	
	@GetMapping("/prixDesc")
	@JsonView(Views.ViewArticlePrixDesc.class)
	public List<Article> findAllByPrixDesc() {
		List<Article> articles = articleRepo.findAllByPrixDesc();

		return articles;
	}
	
	@GetMapping("/typePlat/{nom}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> findByTypePlat(@PathVariable String nom) {
		List<Article> articles = articleRepo.findByTypePlat(nom);

		return articles;
	}
	
	@GetMapping("/restaurantId/{id}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> findByRestaurantId(@PathVariable Long id) {
		List<Article> articles = articleRepo.findByRestaurantId(id);

		return articles;
	}
	
	@GetMapping("/restaurantId/{id}/{typesPlats}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> findByRestaurantIdAndTypesPlats(@PathVariable Long id,@PathVariable TypesPlats typesPlats) {
		List<Article> articles = articleRepo.findByRestaurantIdAndTypesPlats(id,typesPlats);

		return articles;
	}
	
	@GetMapping("/restaurantId/{id}/{vegetarien}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> findVegetarienByRestaurantId(@PathVariable Long id,@PathVariable Boolean vegetarien) {
		List<Article> articles = articleRepo.findVegetarienByRestaurantId(id,vegetarien);

		return articles;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewArticle.class)
	public Article find(@PathVariable Long id) {
		Optional<Article> optArticle = articleRepo.findById(id);

		if (optArticle.isPresent()) {
			return optArticle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article non trouvé");
		}
	}
	
	@GetMapping("/{nom}")
	@JsonView(Views.ViewArticle.class)
	public Article findByNom(@PathVariable String nom) {
		Optional<Article> optArticle = articleRepo.findByNom(nom);

		if (optArticle.isPresent()) {
			return optArticle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article non trouvé");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewArticle.class)
	public Article create(@RequestBody Article article) {
		article = articleRepo.save(article);

		return article;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewArticle.class)
	public Article update(@PathVariable Long id, @RequestBody Article article) {
		if (!articleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		article = articleRepo.save(article);

		return article;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!articleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
		
		articleRepo.deleteById(id);
	}

}
