package speelkaart;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;

@Alternative
public class SpeelKaart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String kleur;
	private String waarde;

	public SpeelKaart() {
	}

	public SpeelKaart(String kleur, String waarde) {
		this.kleur = kleur;
		this.waarde = waarde;
	}

	public String getKleur() {
		return kleur;
	}

	public void setKleur(String kleur) {
		this.kleur = kleur;
	}

	public String getWaarde() {
		return waarde;
	}

	public void setWaarde(String waarde) {
		this.waarde = waarde;
	}

	public String getOmschrijving() {
	//	return kleur + " " + waarde;
		String omschrijving = getKleur() +" "+ getWaarde();
		return omschrijving;
	}

}