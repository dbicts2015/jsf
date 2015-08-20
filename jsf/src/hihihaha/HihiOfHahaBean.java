package hihihaha;

public class HihiOfHahaBean {

	private static final String[] keuzes = {"hihi", "haha"};

	public String kies() {
		return keuzes[(int) (Math.random() * keuzes.length)];
	}

}