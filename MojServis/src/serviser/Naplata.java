package serviser;

import java.util.Scanner;

public class Naplata {

	private Long iznos;
	private Boolean placeno;

	public Naplata() { 
		super();
		this.iznos = 0L;  
		this.placeno = false; 
	}
	
	public String informacijeONaplati () {
		return "Vas racun iznosi: " + getIznos() + "\nVas racun je: " + FormaterZaNaplatu.proveraPlaceno(getPlaceno()) + "\n";
	}
	

	
	// METODA ZA SKRACENJE KODA SVAKE DRUGE METODE KOJA PROVERAVA PREKO EVIDENCIONOG BROJA
	public static EvidencijaRacunara pretragaPoEvidencionomBroju() {
		
		System.out.println("Unesite evidencioni broj: ");
		String eBroj = new Scanner(System.in).nextLine();
		boolean objekatNePostoji = true;
		EvidencijaRacunara e = null;
		Serviser s = null;
		
		for(int i = 0; i < s.getListaRacunara().size(); i++ ) {
			if (s.getListaRacunara().get(i).getEvidencioniBroj().equals(eBroj)) {
				objekatNePostoji = false;
				//return s.getListaRacunara().get(i); //****
				e = s.getListaRacunara().get(i);
				return e;
			}
		}if(objekatNePostoji == true)
			System.err.println("Racunar sa ovim evidencionim brojem ne postoji na servisu! Pokusajte ponovo!");
		
		
		return null;  //****
		
	}
	
	
	// ODLUKA 3 - PLACANJE SERVISA 
	public static void placanjeServisa() {
		
	}
	
	
	// ODLUKA 5 - PRIKAZ ZARADE - KOLIKO JE PLACENO I KOLIKO JE ZA NAPLATU
	public static void zarada () {
		Long placeno = 0L; 
		Long nijePlaceno = 0L;
		Serviser s = null;
		
		
		for(int i = 0; i < s.getListaRacunara().size(); i++) {
			if(s.getListaRacunara().get(i).getNaplataServisa().getPlaceno() == true) {
				placeno = placeno + s.getListaRacunara().get(i).getNaplataServisa().getIznos();
			}else {
				nijePlaceno = nijePlaceno + s.getListaRacunara().get(i).getNaplataServisa().getIznos();
			}
		}
		
		System.out.println("Placeno do sad: " + placeno);
		System.out.println("Za naplatu: " + nijePlaceno);
	}
	
	
	
//get//set	
	public Long getIznos() {
		return iznos;
	}
	public void setIznos(Long iznos) {
		this.iznos = iznos;
	}
	public Boolean getPlaceno() {
		return placeno;
	}
	public void setPlaceno(Boolean placeno) {
		this.placeno = placeno;
	}
	
	
}
