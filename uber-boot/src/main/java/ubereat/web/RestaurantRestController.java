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
import ubereat.model.TypeResto;
import ubereat.model.Views;
import ubereat.model.Views.ViewRestaurantWithPrix;
import ubereat.repository.IRestaurant;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("*")

public class RestaurantRestController {
	

	private TypeResto[]  typesRestos = TypeResto.values();
	
	@Autowired
	private IRestaurant restaurantRepo;

	@GetMapping("")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findAll() {
		List<Restaurant> restaurants = restaurantRepo.findAll();

		return restaurants;
	}
	
	@GetMapping("/orderByRate")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findAllOrderByRate() {
		List<Restaurant> restaurants = restaurantRepo.findAllOrderByRate();

		return restaurants;
	}
	
	@GetMapping("{open}/{livraison}/{emporter}/{stars}/{minprix}/{maxprix}")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant>findAllWithFilters(@PathVariable boolean open ,@PathVariable boolean livraison,@PathVariable boolean emporter,@PathVariable double stars,@PathVariable double minprix,@PathVariable double maxprix) {
		List<Restaurant> restaurants = restaurantRepo.findAllWithFilters(open,livraison,emporter,stars,minprix,maxprix);
		return restaurants;
	}
	
	
	@GetMapping("{open}/{livraison}/{emporter}/{stars}/{types}/{minprix}/{maxprix}")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant>findAllByTypes(@PathVariable boolean open ,@PathVariable boolean livraison,@PathVariable boolean emporter,@PathVariable double stars,@PathVariable String types,@PathVariable double minprix,@PathVariable double maxprix) {
		List<Restaurant> restaurants = restaurantRepo.findAllByTypes(open,livraison,emporter,stars,TypeResto.valueOf(types),minprix,maxprix);
		return restaurants;
	}
	/*
	@GetMapping("/open/cp/{cp}")
	public List<Restaurant> finfAllCpOpen(@PathVariable String cp){
		List<Restaurant> restaurantsopen = restaurantRepo.findOpen();
		List<Restaurant> restaurantscp =restaurantRepo.findAllByCP(cp);
		List<Restaurant> restaurants=new ArrayList<Restaurant>();
		for(Restaurant res1 : restaurantsopen) {
			for(Restaurant res2 :restaurantscp){
				if(res1 == res2)
					restaurants.add(res1);	
			}
		}
		return restaurants;
	}

*/	
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
	
	@GetMapping("/monResto/{id}")
	@JsonView(Views.ViewRestaurantWithArticle.class)
	public Restaurant findByRestaurateur(@PathVariable Long id) {
		Optional<Restaurant> optRestaurant = restaurantRepo.findByRestaurateur(id);

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
