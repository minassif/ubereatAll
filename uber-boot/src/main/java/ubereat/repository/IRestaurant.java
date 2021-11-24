package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Restaurant;


public interface IRestaurant extends JpaRepository<Restaurant, Long>{

}
