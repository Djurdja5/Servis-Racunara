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
