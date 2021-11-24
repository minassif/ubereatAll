package ubereat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name="id_client")
public class Client extends Utilisateur {
	
	private String cb;
	@OneToMany(mappedBy="client")
	private List<Commande> commandes =new ArrayList<Commande>();
	@Embedded
	private Adresse adresse;
	//private List<Adresse> adresses =new ArrayList<Adresse>(); // to check ? 
	
	public Client() {
		super();
	}
	
	public Client(String cb, List<Commande> commandes, Adresse adresse) {
		super();
		this.cb = cb;
		this.commandes = commandes;
		this.adresse = adresse;
	}

	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

}
