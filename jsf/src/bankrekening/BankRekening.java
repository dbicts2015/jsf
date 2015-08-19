package bankrekening;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BankRekening implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject private Event<BankRekeningEvent> rekening_events;
	
	private BigDecimal saldo = new BigDecimal(0);

	public void storten(BigDecimal bedrag) {
		setSaldo(saldo.add(bedrag));
	}

	public void afhalen(BigDecimal bedrag) {
		setSaldo(saldo.subtract(bedrag));
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	private void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
		if (saldo.signum() < 0) {
			BankRekeningEvent event = new BankRekeningEvent();
			event.setBedrag(saldo);
			rekening_events.fire(event);
		}
	}

}