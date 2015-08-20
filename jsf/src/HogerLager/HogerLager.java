package HogerLager;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("hogerlager")
@SessionScoped
public class HogerLager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Random random = new Random();
	private int nummer;
	private int gok;
	private int aantalGokken;
	
	@PostConstruct
	public void init() {
		getNieuweNummer();
	}

	public String doeGok() {
		aantalGokken++;
		FacesContext context = FacesContext.getCurrentInstance();
		if (nummer > gok) {
			context.addMessage(null, new FacesMessage("hoger"));
		}
		else if (nummer < gok) {
			context.addMessage(null, new FacesMessage("Het getal is lager"));
		}
		else {
			return "hogerlagerok";
		}
		return null;
	}

	public String reset() {
		aantalGokken = 0;
		getNieuweNummer();
		return "hogerlager";
	}

	private void getNieuweNummer() {
		nummer = random.nextInt(10) + 1;
	}

	public int getNummer() {
		return nummer;
	}

	public int getAantalGokken() {
		return aantalGokken;
	}

	public void setGok(int gok) {
		this.gok = gok;
	}

	public int getGok() {
		return gok;
	}

}