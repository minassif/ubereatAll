package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Restaurant;


public interface IRestaurant extends JpaRepository<Restaurant, Long>{
	
	
	

	@Query("select e from Restaurant e where e.pricerange > pricerange")
	List<Restaurant> findAllWithPrix(@Param("pricerange") Double pricerange);
	
	
	@Query("select e from Restaurant e where e.adresse.ville =: ville")
	List<Restaurant> findAllByVille(@Param("ville") String ville);
	
	@Query("select e from Restaurant e where e.adresse.codepostale =: codepostale")
	List<Restaurant> findAllByCP(@Param("codepostale") String codepostale);

	
	@Query("select e from Restaurant e where e.nom like nom")
	List<Restaurant>findALLByNom(@Param("nom") String nom);
	
	
	@Query("select e from Restaurant e where e.rate > rate")
	List<Restaurant> findAllByRate(@Param("rate") Double rate);
	
	@Query("select e from Restaurant e where e.typeResto =: typeResto")
	List<Restaurant>findAllByType(@Param("typeResto") String typeResto);

}
