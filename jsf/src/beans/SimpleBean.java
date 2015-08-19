package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SimpleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String naam;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getBegroeting() {
		return naam == null ? "allemaal" : naam;
	}

}