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



import ubereat.model.Article;
import ubereat.repository.IArticle;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleRestController {
	
	
	@Autowired
	private IArticle articleRepo;
	
	@GetMapping("")
	public List<Article> findAll() {
		List<Article> articles = articleRepo.findAll();

		return articles;
	}
	
	@GetMapping("{id}")
	public Article find(@PathVariable Long id) {
		Optional<Article> optArticle = articleRepo.findById(id);

		if (optArticle.isPresent()) {
			return optArticle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article non trouvé");
		}
	}
	
	@PostMapping("")
	public Article create(@RequestBody Article article) {
		article = articleRepo.save(article);

		return article;
	}

	@PutMapping("/{id}")
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
