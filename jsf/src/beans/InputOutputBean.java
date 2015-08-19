package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

import bankrekening.BankRekening;

@Named
@RequestScoped
public class InputOutputBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final DecimalFormat format = new DecimalFormat("0.00");
	
	@Inject
	private BankRekening rekening;

	@Min(0)
	private BigDecimal bedrag;
	
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