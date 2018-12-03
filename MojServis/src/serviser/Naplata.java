package serviser;

import demo.ProveraExceptiona;

public class Naplata {

	private Long iznos;
	private Boolean placeno;

	public Naplata() { 
		super();
		this.iznos = 0L;  
		this.placeno = false; 
	}
	
	public String informacijeONaplati () {
		return "-INFORMACIJE O NAPLATI-" + "\r\nVas racun iznosi: " + getIznos() + "\r\nVas racun je: " + FormaterZaNaplatu.proveraPlaceno(getPlaceno()) + "\r\n";
	}
	
	
	
	// ODLUKA 3 - PLACANJE SERVISA I IZDAVANJE RACUNA
	public static void placanjeServisa () {
		EvidencijaRacunara e = Serviser.pretragaPoEvidencionomBroju();
		
		if(e != null) {  //?
			Long cena = ProveraExceptiona.proveraBrojaLongZaCenuS("Unesite cenu servisa: ");
			e.getNaplataServisa().setIznos(cena);
			
			System.out.println("Izdaj racuna");
			e.getNaplataServisa().setPlaceno(true);
			e.setStatusServisa(Status.ZAVRSEN);
		}
	}
	
	
	
	// ODLUKA 7 - PRIKAZ ZARADE - KOLIKO JE NAPLACENO I KOLIKO JE ZA NAPLATU OSTALO
	public static void zarada () {
		Long placeno = 0L;
		Long nijePlaceno = 0L; 
		
		for(int i = 0; i < Serviser.getListaRacunara().size(); i++) {
			if(Serviser.getListaRacunara().get(i).getNaplataServisa().getPlaceno() == true) {
				placeno = placeno + Serviser.getListaRacunara().get(i).getNaplataServisa().getIznos();
			}else {
				nijePlaceno = nijePlaceno + Serviser.getListaRacunara().get(i).getNaplataServisa().getIznos();
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
