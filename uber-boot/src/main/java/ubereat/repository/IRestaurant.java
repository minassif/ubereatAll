package ubereat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Client;
import ubereat.model.Restaurant;


public interface IRestaurant extends JpaRepository<Restaurant, Long>{
	
	
	

	@Query("select e from Restaurant e where e.pricerange > pricerange")
	List<Restaurant> findAllWithPrix(@Param("pricerange") Double pricerange);
	
	
	@Query("select e from Restaurant e where e.adresse.ville =: ville")
	List<Restaurant> findAllByVille(@Param("ville") String ville);
	
	@Query("select e from Restaurant e where e.adresse.codepostale =: codepostale")
	List<Restaurant> findAllByCP(@Param("codepostale") String codepostale);

	
	/*@Query("select e from Restaurant e where e.nom like nom")
	List<Restaurant>findALLByNom(@Param("nom") String nom);
	*/
	List<Restaurant> findByNomContaining(String nom);
	
	@Query("select e from Restaurant e where e.rate > rate")
	List<Restaurant> findAllByRate(@Param("rate") Double rate);
	
	@Query("select e from Restaurant e where e.typeResto =: typeResto")
	List<Restaurant>findAllByType(@Param("typeResto") String typeResto);
	
	@Query("select e from Restaurant e where e.open =: true")
	List<Restaurant>findOpen();
	
	@Query("select e from Restaurant e where e.open=:true and e.adresse.codepostale=:codepostale")
	List<Restaurant> findAllOpenByCp(@Param("codepostale") String codepostale);
	
    @Query("select e from Restaurant e where e.open=:true and e.adresse.codepostale=:codepostale and pricerange > 100")
    List<Restaurant>findAllCpOpenExpensive(@Param("codepostale") String codepostale);
    
    @Query("select e from Restaurant e where e.open=:true and e.adresse.codepostale=:codepostale and pricerange < 100 and pricerange >75 ")
    List<Restaurant>findAllCpOpenLessExpensive(@Param("codepostale") String codepostale);
    
    @Query("select e from Restaurant e where e.open=:true and e.adresse.codepostale=:codepostale and pricerange < 75 and pricerange > 45")
    List<Restaurant>findAllCpOpenLessCheap(@Param("codepostale") String codepostale);
    
    @Query("select e from Restaurant e where e.open=:true and e.adresse.codepostale=:codepostale and pricerange < 45")
    List<Restaurant>findAllCpOpenCheap(@Param("codepostale") String codepostale);
    
    @Query("select r from Restaurant r order by r.rate desc")
    List<Restaurant>findAllOrderByRate();
    
    @Query("select distinct r from Restaurant r left join fetch r.restaurateur re where re.id=:id")
	Optional <Restaurant> findByRestaurateur(@Param("id") Long id);
    
    
   
}
