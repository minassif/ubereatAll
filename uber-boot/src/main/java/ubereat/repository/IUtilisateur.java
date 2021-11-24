package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Utilisateur;


public interface IUtilisateur extends JpaRepository<Utilisateur, Long> {


}
