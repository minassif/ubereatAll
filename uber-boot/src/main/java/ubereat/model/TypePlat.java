package ubereat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class TypePlat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String nom;
	@ManyToOne
	private Article article;
	
	public TypePlat() {
	}
	
	public TypePlat(String nom, Article article) {
		super();
		this.nom = nom;
		this.article = article;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Article getArticles() {
		return article;
	}

	public void setArticles(Article article) {
		this.article = article;
	}

	public int getVersion() {
		return version;
	}

	
	
	
	
	

}
