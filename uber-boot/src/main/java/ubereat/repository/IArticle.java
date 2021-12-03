package ubereat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Article;
import ubereat.model.TypePlat;



public interface IArticle extends JpaRepository<Article, Long> {


	@Query("select a from Article a order by a.prix asc")
	List<Article> findAllByPrixAsc();
	
	@Query("select a from Article a order by a.prix desc")
	List<Article> findAllByPrixDesc();
	
	@Query("select a from Article a where a.restaurant.id = :idRestaurant")
	List<Article> findByRestaurantId(@Param("idRestaurant") Long id);
	
	@Query("select a from Article a where a.nom = :nom")
	Optional<Article> findByNom(@Param("nom") String nom);
	/*
	@Query("select a from Article a where a.restaurant.id = :idRestaurant and a.restaurant.typesPlats = :typePlat")
	List<Article> findByRestaurantIdAndTypesPlats(@Param("idRestaurant") Long id,@Param("typePlat") TypePlat typePlat);
	*/
	/*@Query("select a from Article a where a.restaurant.id = :idRestaurant and a.restaurant.vegetarien = :vegetarien")
	List<Article> findVegetarienByRestaurantId(@Param("idRestaurant") Long id,@Param("vegetarien") Boolean vegetarien);
	*/
}
