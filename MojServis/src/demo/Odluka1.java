package demo;

import java.util.Scanner;

import racunar.Desktop;
import racunar.LapTop;
import racunar.Racunar;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Serviser;
import serviser.Status;

public class Odluka1 {
	
	public Odluka1() {
		super();
	}
//	OTVORENA NOVA KLASA ZA KODA IZ ODLUKE 1 // ZAMENJUJE CEO CITAC I KOD U APP
	public EvidencijaRacunara unosEvidencijeZaSveRacunare() {
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite evidencioni broj: ");
		String evBroj = ulaz.nextLine();
		System.out.println("Unesite ime vlasnika: ");
		String ime = ulaz.nextLine();
	
		System.out.println("Unesite racunar: Unesite L za LapTop i D za Desktop! ");
		boolean uslov = true;
		String odluka;
		
		do {			
			odluka = ulaz.nextLine().toUpperCase(); //****
			if(odluka.equals("L")) 
				uslov = false;
			else if(odluka.equals("D"))
				uslov = false;
			else {
				System.out.println("Pogresan unos! Pokusajte ponovo");
				uslov = true;
			}
		}while (uslov == true);
		
		Scanner unos1 = new Scanner(System.in);		
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos1.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos1.nextLine();
		Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");		
		
		Racunar r = null;
		
		if(odluka.equals("L")) {
			Integer velicina = ProveraExceptiona.proveraBroja("Unesite velicinu displeja: ");
			r = new LapTop(serijskiBr, brzina, marka, velicina);
		
		} else if(odluka.equals("D")) {
			TipKucista ispisTk = ProveraExceptiona.proveraEnumaTipKuciste("Unesite tip kucista: ATX ili MICRO_ATX");
			r = new Desktop(serijskiBr, brzina, marka, ispisTk);
		}
		
		Status s = ProveraExceptiona.proveraEnumaStatus("Unesite status: ");
		Integer dani = ProveraExceptiona.proveraBroja("Unesite broj dana za koji ce racunar biti popravljen: ");
		return new EvidencijaRacunara(evBroj, ime, r, s, dani);
	}
}