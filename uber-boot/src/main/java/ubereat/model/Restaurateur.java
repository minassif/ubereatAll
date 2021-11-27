package ubereat.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@PrimaryKeyJoinColumn(name="id_restaurateur")
@JsonView(Views.ViewCommon.class)
public class Restaurateur extends Utilisateur{
	
@OneToOne	
@JsonView(Views.ViewRestaurateur.class)
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
