package bankrekening;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankRekeningEvent implements Serializable {

	private static final long serialVersionUID = 1L;	
	private BigDecimal bedrag;

	public BigDecimal getBedrag() {
		return bedrag;
	}

	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

}