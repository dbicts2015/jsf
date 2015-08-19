package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2367527182783491645L;
	
	private String username;
	private String password;
	
	@Inject
	private DatabaseBean database;

	public String validate(String client_id, FacesContext context) {
		if (!database.isGeldig(username, password)) {
			// FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(client_id, new FacesMessage("Gebruikersnaam of wachtwoord onjuist."));
			return null;
		}
		return "controlpanel";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}