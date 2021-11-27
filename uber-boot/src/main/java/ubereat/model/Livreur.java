package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@PrimaryKeyJoinColumn(name="id_livreur")
@JsonView(Views.ViewCommon.class)
public class Livreur extends Utilisateur {
	
@Enumerated(EnumType.STRING)
private Transport transport;
private Double rate;
@OneToMany(mappedBy ="livreur")
@JsonView(Views.ViewLivreur.class)
private List<Commande> commandes = new ArrayList<Commande>();


public Livreur() {}

public Livreur(Transport transport) {
	super();
	this.transport = transport;
}


public Livreur(Transport transport, Double rate, List<Commande> commandes) {
	super();
	this.transport = transport;
	this.rate = rate;
	this.commandes = commandes;
}


public Transport getTransport() {
	return transport;
}
public void setTransport(Transport transport) {
	this.transport = transport;
}
public Double getRate() {
	return rate;
}
public void setRate(Double rate) {
	this.rate = rate;
}
public List<Commande> getCommandes() {
	return commandes;
}
public void setCommandes(List<Commande> commandes) {
	this.commandes = commandes;
}






}
