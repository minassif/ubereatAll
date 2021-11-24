package ubereat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ubereat.model.Client;


public interface IClient extends JpaRepository<Client, Long> {


}
