package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.TypePlat;
import ubereat.model.TypeResto;



public interface ITypePlat extends JpaRepository<TypePlat, Long> {

	@Query("select distinct t from TypePlat t where t.nom Like %:string% ")
	List<TypePlat> findByName(@Param("string") String string);

}
