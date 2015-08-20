package speelkaart.beans;

import javax.enterprise.inject.Produces;

import speelkaart.SpeelKaart;
import speelkaart.SpeelkaartenBoek;

public class SpeelkaartProducer {

	@Produces public SpeelKaart getSpeelKaart(SpeelkaartenBoek boek) {
		return boek.geefKaart();
	}

}