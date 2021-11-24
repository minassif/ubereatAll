package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Commande;


public interface ICommande extends JpaRepository<Commande, Long> {


}
