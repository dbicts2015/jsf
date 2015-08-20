package quiz;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String[] vragen = {
		"hallo", "een", "twee"
	};
	
	private final String[] antwoorden = new String[vragen.length];
	private int index;
	
	public void next() {
		index++;
	}

	public void previous() {
		index--;
	}
	
	public String getVraag() {
		return index < vragen.length ? vragen[index] : "Thanks for your time";
	}
	
	public String getAntwoord() {
		return index < vragen.length ? antwoorden[index] : null;
	}
	
	public void setAntwoord(String antwoord) {
		this.antwoorden[index] = antwoord;
	}
	
	public boolean heeftVorige() {
		return index > 0;
	}
	
	public boolean heeftVolgende() {
		return index < vragen.length;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}