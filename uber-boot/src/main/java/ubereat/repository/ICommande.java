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
	
	@Query("select distinct c from Commande c where c.restaurant.id = :idRestaurant")
	List<Commande> findAllByRestaurant(@Param("idRestaurant") Long idRestaurant);
}
