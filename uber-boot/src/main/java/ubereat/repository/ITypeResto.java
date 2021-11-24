package ubereat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.TypeResto;



public interface ITypeResto extends JpaRepository<TypeResto, Long> {

	@Query("select distinct t from TypeResto t where t.nom Like %:string% ")
	List<TypeResto> findByName(@Param("string") String string);
}
