package primer1;

public class Nastavnik {
	private int nastavnik_id;
	private String ime, prezime, zvanje;
	
	public Nastavnik(){
		
	}
	
	public Nastavnik(int nastavnik_id, String ime, String prezime, String zvanje) {
		super();
		this.nastavnik_id = nastavnik_id;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}
	public int getNastavnik_id() {
		return nastavnik_id;
	}
	public void setNastavnik_id(int nastavnik_id) {
		this.nastavnik_id = nastavnik_id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	
}
