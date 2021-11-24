package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Restaurateur;

public interface IRestaurateur extends JpaRepository<Restaurateur, Long> {


}
