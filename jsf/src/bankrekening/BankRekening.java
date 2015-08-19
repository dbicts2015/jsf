package bankrekening;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class BankRekening implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal saldo = new BigDecimal(0);

	public void storten(BigDecimal bedrag) {
		saldo = saldo.add(bedrag);
	}

	public void afhalen(BigDecimal bedrag) {
		if (saldo.subtract(bedrag).signum() < 0)
			throw new IllegalStateException("Saldo ontoereikend.");
		saldo = saldo.subtract(bedrag);
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

}