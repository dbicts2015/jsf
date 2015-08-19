package beans;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class DatabaseBean {

	private static final HashMap<String, String> namen = new HashMap<String, String>();

	static {
		namen.put("Jan", "Jan");
		namen.put("Piet", "Piet");
		namen.put("Joris", "Joris");
		namen.put("Corneel", "Corneel");
	}

	public boolean isGeldig(String naam, String paswoord) {
		return paswoord.equals(namen.get(naam));
	}

	public boolean isGeldig556(String naam, String paswoord) {
		if (namen.containsKey(naam)) {
			return namen.get(naam).equals(paswoord);
		}
		return false;
	}

}