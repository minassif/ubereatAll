package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class TypePlat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String nom;
	@OneToMany(mappedBy= "typePlat")
	private List<Article> articles=new ArrayList<Article>();
	
	public TypePlat() {
	}
	
	public TypePlat(String nom, List<Article> articles) {
		super();
		this.nom = nom;
		this.articles = articles;
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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getVersion() {
		return version;
	}

	
	
	
	
	

}
