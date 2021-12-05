package ubereat.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;


@Embeddable
@JsonView(Views.ViewCommon.class)
public class Adresse {
	
	private String voie;
	private String complement;
	private String codepostale;
	private String ville;

	
	public Adresse() {
		super();
	}
	
	public Adresse(String voie, String complement, String codepostale, String ville) {
		super();
		this.voie = voie;
		this.complement = complement;
		this.codepostale = codepostale;
		this.ville = ville;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodepostale() {
		return codepostale;
	}
	public void setCodepostale(String codepostale) {
		this.codepostale = codepostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	

}
