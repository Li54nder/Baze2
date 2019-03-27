package primer1;

public class GlavniProgram {

	public static void main(String[] args) {
		Nastavnik n=new Nastavnik(6, "Miki", "Mikic", "docent");
		DBF.unesiNastavnika(n);
		if(DBF.obrisiNastavnika(6))
			System.out.println("Nastavnik je uspesno obrisan");
		else
			System.out.println("Doslo je do greske prilikom brisanja.");
		
		DBF.prikaziPredmete(3);
		if(DBF.promeniPrezime(5, "Mirkovic"))
			System.out.println("Nastavniku je uspesno promenjeno prezime");
		else
			System.out.println("Doslo je do greske prilikom promene prezimena.");
		DBConnection.closeConnection();
	}

}
