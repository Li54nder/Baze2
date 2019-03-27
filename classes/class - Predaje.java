package primer1;

public class Predaje {

	private int nastavnik_id;
	private int predmet_id;
	
	public Predaje() {
		// TODO Auto-generated constructor stub
	}

	public Predaje(int nastavnik_id, int predmet_id) {
		super();
		this.nastavnik_id = nastavnik_id;
		this.predmet_id = predmet_id;
	}

	public int getNastavnik_id() {
		return nastavnik_id;
	}

	public void setNastavnik_id(int nastavnik_id) {
		this.nastavnik_id = nastavnik_id;
	}

	public int getPredmet_id() {
		return predmet_id;
	}

	public void setPredmet_id(int predmet_id) {
		this.predmet_id = predmet_id;
	}
	
	

}
