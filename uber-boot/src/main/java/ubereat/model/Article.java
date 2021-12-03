package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@JsonView(Views.ViewCommon.class)
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String  nom;
	private double prix;
	private boolean vegetarien;
	private String description;
	private String  img;
	@ManyToMany(mappedBy="articles")
	@JsonView(Views.ViewArticle.class)
	private List<Commande> commandes=new ArrayList<Commande>();
	@ManyToOne
	@JsonView(Views.ViewArticle.class)
	private Restaurant restaurant;
	private TypePlat typePlat;
	
	public Article() {}
	
	public Article(double prix,String nom,boolean vegetarien, String description, String img, List<Commande> commande, Restaurant restaurant,
			TypePlat typePlat) {
		super();
		this.nom= nom;
		this.prix = prix;
		this.vegetarien = vegetarien;
		this.description = description;
		this.img = img;
		this.commandes = commande;
		this.restaurant = restaurant;
		this.typePlat = typePlat;
	}
	
	

	public boolean isVegetarien() {
		return vegetarien;
	}

	public void setVegetarien(boolean vegetarien) {
		this.vegetarien = vegetarien;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public TypePlat getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(TypePlat typePlat) {
		this.typePlat = typePlat;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	
	
	
	
	
	
	

}
