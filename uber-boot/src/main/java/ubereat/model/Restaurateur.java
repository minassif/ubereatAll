package ubereat.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_restaurateur")
public class Restaurateur extends Utilisateur{
@OneToOne	
private Restaurant restaurant;

public Restaurateur() {}

public Restaurateur(Restaurant restaurant) {
	super();
	this.restaurant = restaurant;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

}
