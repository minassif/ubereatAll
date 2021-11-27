package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String nom;
	private  boolean livraison;
	private  boolean emporter;
	private boolean open;
	private String img;
	private String  description;
	private double rate;
	private double pricerange;
	@Embedded
	private Adresse adresse;
	@OneToOne
	@JsonView(Views.ViewRestaurant.class)
    private Restaurateur restaurateur;
    @OneToMany(mappedBy= "restaurant")
    @JsonView(Views.ViewRestaurant.class)
    private List<TypeResto> typeRestos=new ArrayList<TypeResto>();
    @OneToMany(mappedBy= "restaurant")
    @JsonView(Views.ViewRestaurant.class)
    private List<Article> articles=new ArrayList<Article>();
    
    public Restaurant() {
    }
    
	public Restaurant(String nom, String img, String descrription) {
		super();
		this.nom = nom;
		this.img = img;
		this.description = descrription;
	}
	
	public Restaurant(String nom, boolean livraison, boolean emporter, boolean open, String img, String description,
			double rate, double pricerange, Adresse adresse, Restaurateur restaurateur, List<TypeResto> typeRestos,
			List<Article> articles) {
		super();
		this.nom = nom;
		this.livraison = livraison;
		this.emporter = emporter;
		this.open = open;
		this.img = img;
		this.description = description;
		this.rate = rate;
		this.pricerange = pricerange;
		this.adresse = adresse;
		this.restaurateur = restaurateur;
		this.typeRestos = typeRestos;
		this.articles = articles;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isLivraison() {
		return livraison;
	}
	public void setLivraison(boolean livraison) {
		this.livraison = livraison;
	}
	public boolean isEmporter() {
		return emporter;
	}
	public void setEmporter(boolean emporter) {
		this.emporter = emporter;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descrription) {
		this.description = descrription;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getPricerange() {
		return pricerange;
	}
	public void setPricerange(double pricerage) {
		this.pricerange = pricerage;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Restaurateur getRestaurateur() {
		return restaurateur;
	}
	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}
	public List<TypeResto> getTypeRestos() {
		return typeRestos;
	}
	public void setTypeRestos(List<TypeResto> typeRestos) {
		this.typeRestos = typeRestos;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	


}
