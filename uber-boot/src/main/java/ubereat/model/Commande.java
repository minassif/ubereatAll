package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private double prix;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int tempsPrep;
	private double rateResto;
	private double ratelivreur;
	@ManyToOne
	private Livreur livreur;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "commande")
	private List<Article> articles =new ArrayList<Article>();
	
	public Commande() {
	}
	
	public Commande(double prix, Status status, int tempsPrep, double rateResto, double ratelivreur, Livreur livreur,
			Client client, List<Article> articles) {
		super();
		this.prix = prix;
		this.status = status;
		this.tempsPrep = tempsPrep;
		this.rateResto = rateResto;
		this.ratelivreur = ratelivreur;
		this.livreur = livreur;
		this.client = client;
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


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public int getTempsPrep() {
		return tempsPrep;
	}


	public void setTempsPrep(int tempsPrep) {
		this.tempsPrep = tempsPrep;
	}


	public double getRateResto() {
		return rateResto;
	}


	public void setRateResto(double rateResto) {
		this.rateResto = rateResto;
	}


	public double getRatelivreur() {
		return ratelivreur;
	}


	public void setRatelivreur(double ratelivreur) {
		this.ratelivreur = ratelivreur;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	

}
