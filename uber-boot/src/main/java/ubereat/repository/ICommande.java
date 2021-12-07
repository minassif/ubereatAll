package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Commande;


public interface ICommande extends JpaRepository<Commande, Long> {
	@Query("select distinct c from Commande c where c.status = :string")
	List<Commande> findAllWithStatus(@Param("string") String string);
	
	@Query("select distinct c from Commande c where c.livreur.id = :idLivreur")
	List<Commande> findAllByLivreur(@Param("idLivreur") Long idLivreur);
	
	@Query("select distinct c from Commande c where c.client.id = :idClient")
	List<Commande> findAllByClient(@Param("idClient") Long idClient);
	
	@Query("select c from Commande c left join fetch c.articles where c.livreur.id = :idLivreur")
	List<Commande> findAllByLivreurWithArticles(@Param("idLivreur") Long idLivreur);
	
	@Query("select c from Commande c left join fetch c.articles where c.client.id = :idClient")
	List<Commande> findAllByClientWithArticles(@Param("idClient") Long idClient);
	
	@Query("select c from Commande c left join fetch c.articles where c.restaurant.id = :idRestaurant")
	List<Commande> findAllByRestaurantWithArticles(@Param("idRestaurant") Long idRestaurant);
	
//	@Query("select distinct c from Commande c where c.restaurant.id = :idRestaurant")
//	List<Commande> findAllByRestaurant(@Param("idRestaurant") Long idRestaurant);
}
