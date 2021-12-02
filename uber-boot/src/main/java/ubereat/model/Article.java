package ubereat.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private double prix;
	private String description;
	private String  img;
	@ManyToOne
	@JsonView(Views.ViewArticle.class)
	private Commande commande;
	@ManyToOne
	@JsonView(Views.ViewArticle.class)
	private Restaurant restaurant;
	@OneToMany(mappedBy="article")
	@JsonView(Views.ViewArticle.class)
	private List<TypePlat> typesPlat;
	
	public Article() {}
	
	public Article(double prix, String description, String img, Commande commande, Restaurant restaurant,
			List<TypePlat> typesPlat) {
		super();
		this.prix = prix;
		this.description = description;
		this.img = img;
		this.commande = commande;
		this.restaurant = restaurant;
		this.typesPlat = typesPlat;
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
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<TypePlat> getTypePlat() {
		return typesPlat;
	}

	public void setTypePlat(List<TypePlat> typesPlat) {
		this.typesPlat = typesPlat;
	}
	
	
	
	
	
	
	

}
