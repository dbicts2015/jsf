package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

import bankrekening.BankRekening;
import bankrekening.BankRekeningEvent;

@Named
@RequestScoped
public class InputOutputBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final DecimalFormat format = new DecimalFormat("0.00");
	
	@Inject
	private BankRekening rekening;

	@Min(0)
	private BigDecimal bedrag;
	
	private String kleur = "wit";
	
	public void onRekeningNegatief(@Observes BankRekeningEvent event) {
		kleur = "rood";
	}
	
	public String getKleur() {
		return kleur;
	}
	
	public void storten() {
		rekening.storten(bedrag);
	}

	public void afhalen() {
		try {
			rekening.afhalen(bedrag);
		} catch (IllegalStateException ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
		}
	}

	public BigDecimal getBedrag() {
		return bedrag;
	}

	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

	public String getSaldo() {
		return format.format(rekening.getSaldo());
	}

}