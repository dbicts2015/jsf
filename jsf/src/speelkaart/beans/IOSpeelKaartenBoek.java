package speelkaart.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import speelkaart.SpeelKaart;
import speelkaart.SpeelkaartenBoek;

@Named("kaartenboek")
@RequestScoped
public class IOSpeelKaartenBoek implements Serializable {

	private static final long serialVersionUID = 341580925865145361L;

	@Inject private SpeelkaartenBoek boek;
	
	public String getKaart() {
		SpeelKaart kaart = boek.geefKaart();
		return kaart == null ? "Er zijn geen kaarten meer." : kaart.getOmschrijving();
	}

	public void schud() {
		boek.schud();
	}

}