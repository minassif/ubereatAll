package ubereat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Client;


public interface IClient extends JpaRepository<Client, Long> {

	@Query("select distinct c from Client c left join fetch c.adresse ad where c.id=:id")
	Optional <Client> findWithAdress(@Param("id") Long id);

}
