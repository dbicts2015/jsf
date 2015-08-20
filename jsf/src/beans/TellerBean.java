package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// een didactische bean om de life cycle en scope van managed beans te illustreren
// instanties zijn gedefinieerd in faces-config.xml
public class TellerBean {
	private int teller;

	public int getTeller() {
		return teller;
	}

	public void setTeller(int teller) {
		this.teller = teller;
	}
	
	public String verhoog(){
		teller++;
		return null;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("PostConstruct van TellerBean");
	}
	
	public TellerBean(){
		System.out.println("ctor van TellerBean");
	}
	
	@PreDestroy
	public void byebye(){
		System.out.println("PreDestroy");
	}
	
}
