package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Restaurant;
import ubereat.model.TypeResto;


public interface IRestaurant extends JpaRepository<Restaurant, Long>{
	

    @Query("select r from Restaurant r order by r.rate desc")
    List<Restaurant>findAllOrderByRate();
 
    @Query("select e from Restaurant e where e.open=:open and e.livraison=:livraison and e.emporter=:emporter and e.rate >=:stars and e.typeResto =:types and pricerange>=:minprix and pricerange<=:maxprix")
    List<Restaurant>findAllByTypes(@Param("open") boolean open,@Param("livraison") boolean livraison,@Param("emporter") boolean emporter,@Param("stars") double stars,@Param("types") TypeResto types,@Param("minprix") double minprix,@Param("maxprix") double maxprix);
    
    @Query("select e from Restaurant e where e.open=:open and e.livraison=:livraison and e.emporter=:emporter and e.rate >=:stars and pricerange>=:minprix and pricerange<=:maxprix")
    List<Restaurant>findAllWithFilters(@Param("open") boolean open,@Param("livraison") boolean livraison,@Param("emporter") boolean emporter,@Param("stars") double stars,@Param("minprix") double minprix,@Param("maxprix") double maxprix);
}
