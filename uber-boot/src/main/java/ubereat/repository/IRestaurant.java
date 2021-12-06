package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Restaurant;
import ubereat.model.TypeResto;


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
	
	
	@Query("select e from Restaurant e where e.typeResto Like 'FastFood'")
	List<Restaurant>findAllByTypeFastFood();
	
	@Query("select e from Restaurant e where e.typeResto Like 'Italienne'")
	List<Restaurant>findAllByTypeItal();
	
	@Query("select e from Restaurant e where e.typeResto Like 'Asiatique'")
	List<Restaurant>findAllByTypeAsia();
	
	
	@Query("select e from Restaurant e where e.typeResto Like 'Latino'")
	List<Restaurant>findAllByTypeLat();
	
	@Query("select e from Restaurant e where e.typeResto Like 'Halal'")
	List<Restaurant>findAllByTypeHal();
	
	
	@Query("select e from Restaurant e where e.typeResto Like 'Vegetarien'")
	List<Restaurant>findAllByTypeVeg();
	
	@Query("select e from Restaurant e where e.typeResto Like 'Francais'")
	List<Restaurant>findAllByTypeFr();
	
	
	
	@Query("select e from Restaurant e where e.open = true")
	List<Restaurant>findOpen();
	@Query("select e from Restaurant e where e.livraison = true")
	List<Restaurant>findLivraisonGratuite();
	
	@Query("select e from Restaurant e where e.open = true and e.livraison = true")
	List<Restaurant>findLivraisonGratuiteOpen();
	
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
  
    @Query("select e from Restaurant e where e.open=:open and e.livraison=:livraison and e.emporter=:emporter and e.rate >=:stars"  )
    List<Restaurant>findAllOpenLiv(@Param("open") boolean open,@Param("livraison") boolean livraison,@Param("emporter") boolean emporter,@Param("stars") double stars);
    
    @Query("select e from Restaurant e where e.open=:open and e.livraison=:livraison and e.emporter=:emporter and e.rate >=:stars and e.typeResto like :type"  )
    List<Restaurant>findAllWithTypes(@Param("open") boolean open,@Param("livraison") boolean livraison,@Param("emporter") boolean emporter,@Param("stars") double stars, @Param("type") TypeResto type);
    /*
    @Query("select e from Restaurant e where e.open=:open and e.livraison=:livraison and e.emporter=:emporter and e.rate >=:stars and e.typeResto like :Type"  )
    List<Restaurant>findAllWithTypesSt(@Param("open") boolean open,@Param("livraison") boolean livraison,@Param("emporter") boolean emporter,@Param("stars") double stars, @Param("type") String type);
*/   

}
