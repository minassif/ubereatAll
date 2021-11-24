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

import ubereat.model.Restaurant;
import ubereat.model.Views;
import ubereat.repository.IRestaurant;

@RestController
@RequestMapping("/Restaurant")
@CrossOrigin("*")

public class RestaurantRestController {
	
	@Autowired
	private IRestaurant restaurantRepo;

	@GetMapping("")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findAll() {
		List<Restaurant> restaurants = restaurantRepo.findAll();

		return restaurants;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewRestaurant.class)
	public Restaurant find(@PathVariable Long id) {
		Optional<Restaurant> optRestaurant = restaurantRepo.findById(id);

		if (optRestaurant.isPresent()) {
			return optRestaurant.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
	}


	@PostMapping("")
	@JsonView(Views.ViewRestaurant.class)
	public Restaurant create(@RequestBody Restaurant restaurant) {
		restaurant = restaurantRepo.save(restaurant);

		return restaurant;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewRestaurant.class)
	public Restaurant update(@PathVariable Long id, @RequestBody Restaurant Restaurant) {
		if (!restaurantRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		Restaurant = restaurantRepo.save(Restaurant);

		return Restaurant;
	}

	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!restaurantRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		restaurantRepo.deleteById(id);
	}
}
