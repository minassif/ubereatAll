package ubereat.web;

import java.util.ArrayList;
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
import ubereat.model.Views.ViewRestaurantWithPrix;
import ubereat.repository.IRestaurant;

@RestController
@RequestMapping("/restaurant")
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
	
	@GetMapping("/orderByRate")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findAllOrderByRate() {
		List<Restaurant> restaurants = restaurantRepo.findAllOrderByRate();

		return restaurants;
	}
	
	@GetMapping("pricerange/{pricerange}")
	@JsonView(ViewRestaurantWithPrix.class)
	public List<Restaurant> findRestaurantWithPrrix(@PathVariable Double pricerange) {
		List<Restaurant> restaurants = restaurantRepo. findAllWithPrix(pricerange);

		return restaurants;
	}
	
	/*@GetMapping("nom/{nom}")
	@JsonView(ViewRestaurantWithPrix.class)
	
	public List<Restaurant> findRestaurantWithPrrix(@PathVariable String  nom) {
		List<Restaurant> restaurants = restaurantRepo.findALLByNom( nom);

		return restaurants;
	}*/
	
	@GetMapping("/search/{nom}")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findAllByNom(@PathVariable String nom) {
		List<Restaurant> matieres = restaurantRepo.findByNomContaining(nom);

		return matieres;
	}
	
	
	@GetMapping("/open")
	public List<Restaurant> findOpen(){
		List<Restaurant> restaurants = restaurantRepo.findOpen();
		return restaurants;
	}
	
	@GetMapping("/cp/{cp}")
	public List<Restaurant> findAllByCp(@PathVariable String cp){
		List<Restaurant> restaurants =restaurantRepo.findAllByCP(cp);
		return restaurants;
	}
	

	@GetMapping("/open/cp/{cp}")
	public List<Restaurant> findAllCpOpen(@PathVariable String cp){
		List<Restaurant> restaurants=restaurantRepo.findAllOpenByCp(cp);
		return restaurants;
		
	}
	
	@GetMapping("/open/cp/expensive/{cp}")
	public List<Restaurant> findAllCpOpenExpensive(@PathVariable String cp){
		List<Restaurant> restaurants=restaurantRepo.findAllCpOpenExpensive(cp);
		return restaurants;
	}
	@GetMapping("/open/cp/lessexpensive/{cp}")
	public List<Restaurant> findAllCpOpenLessExpensive(@PathVariable String cp){
		List<Restaurant> restaurants=restaurantRepo.findAllCpOpenLessExpensive(cp);
		return restaurants;
	}
	@GetMapping("/open/cp/lesscheap/{cp}")
	public List<Restaurant> findAllCpOpenLessCheap(@PathVariable String cp){
		List<Restaurant> restaurants=restaurantRepo.findAllCpOpenLessCheap(cp);
		return restaurants;
	}
	@GetMapping("/open/cp/cheap/{cp}")
	public List<Restaurant> findAllCpOpenCheap(@PathVariable String cp){
		List<Restaurant> restaurants=restaurantRepo.findAllCpOpenCheap(cp);
		return restaurants;
	}
	
	
	@GetMapping("/typeResto/{typeResto}")
	@JsonView(Views.ViewRestaurant.class)
	public List<Restaurant> findRestaurantWithType(@PathVariable String typeResto){
		List<Restaurant> restaurants = restaurantRepo.findAllByType(typeResto);
		return restaurants;
		
	}
	
	@GetMapping("rate/{rate}")
	@JsonView(ViewRestaurantWithPrix.class)
	public List<Restaurant> findAllByRate(@PathVariable Double rate) {
		List<Restaurant> restaurants = restaurantRepo.findAllByRate(rate);

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
	@JsonView(Views.ViewRestaurant.class)
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
