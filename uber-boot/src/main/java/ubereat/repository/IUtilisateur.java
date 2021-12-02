package ubereat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ubereat.model.Utilisateur;


public interface IUtilisateur extends JpaRepository<Utilisateur, Long> {

	@Query("select u from Utilisateur u where u.email = :email and u.password = :password")
	Optional<Utilisateur> findByUsernameAndPassword(@Param("email") String email,@Param("password") String password);
}
