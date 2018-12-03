package demo;

import java.io.IOException;
import java.util.Scanner;
import racunar.Desktop;
import racunar.LapTop;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Naplata;
import serviser.Serviser;
import serviser.Status;

public class App {

	public static void main(String[] args) throws IOException{
		
		
		Serviser mirko = new Serviser();
		
		EvidencijaRacunara er1 = new EvidencijaRacunara("5b", "Isidora", new LapTop("2222", 2000, "Dell", 18), Status.PRIJEM, 3);
		EvidencijaRacunara er2 = new EvidencijaRacunara("3b", "Nemanja", new Desktop("9999", 1500, "Toshida", TipKucista.ATX), Status.PRIJEM, 9);
		EvidencijaRacunara er3 = new EvidencijaRacunara("8b", "Djurdja", new LapTop("1111", 1500, "Dell", 19), Status.PRIJEM, 7);
		EvidencijaRacunara er4 = new EvidencijaRacunara("9b", "Janko", new Desktop("8888", 1800, "Siemens", TipKucista.MICRO_ATX), Status.PRIJEM, 3);

		er1.getNaplataServisa().setIznos(2000L);
		er1.getNaplataServisa().setPlaceno(true);
		er2.getNaplataServisa().setIznos(3000L);
		//placeno false
		er3.getNaplataServisa().setIznos(1000L);
		//placeno false
		er4.getNaplataServisa().setIznos(5000L);
		er4.getNaplataServisa().setPlaceno(true);
		//
		mirko.ubaciUListu(er1);
		mirko.ubaciUListu(er2);
		mirko.ubaciUListu(er3);
		mirko.ubaciUListu(er4);

		// System.out.println("Promet: ");
		//mirko.zarada(); // posle ubacivanja u listu
		
		//new Naplata().zarada();  // ne static metode 
		//new Naplata().placanjeServisa();
		

//		for(int i = 0; i < Serviser.getListaRacunara().size(); i++) {
//			System.out.println(Serviser.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
//		}

		//mirko.promenaStatusaUPreuzet(); //
		//mirko.prikazInformacijaZaSveRacunare();
		
		
		System.out.println("");
		System.out.println("***unos preko komandi***");
		System.out.println("");
		
		boolean prikaz = true;
		
		do {
			System.out.println("");
			System.out.println("Izaberite opciju: ");
			System.out.println("0 - za izlaz iz aplikacije");
			System.out.println("1 - za unos novog racunara na servis");
			System.out.println("2 - za unos cene uredjaja na servisu");
			System.out.println("3 - za placanje servisa i izdavanje racuna");
			System.out.println("4 - za prikaz zarade");
			System.out.println("5 - za prikaz svih uredjaja na servisu");
			System.out.println("6 - za prikaz uredjaja na servisu: po tipu racunara");
			System.out.println("7 - za prikaz uredjaja na servisu: po statusu u kojem se uredjaj nalazi");
			System.out.println("8 - za promenu statusa uredjaja - u PRIPREMA");
			System.out.println("9 - za promenu statusa uredjaja - u PREUZET");
			System.out.println("10 - za stampanje informacija o svim uredjajima na servisu pojedinacno");
			System.out.println("11 - za stampanje informacija o svim uredjajima zajedno");
			System.out.println("12 - za stampanje informacija o svim uredjajima zajedno - po tipu");
			System.out.println("13 - za unos novog racunara na servis i stampanje njegovih informacija");
			
			Scanner unos = new Scanner(System.in);
			String odluka = unos.nextLine();
			
			if(odluka.equals("0")) {
				System.out.println("***Hvala sto ste nasi korisnici***");
				prikaz = false;
			}
			if(odluka.equals("1")) {
				Odluka1 o = new Odluka1();
				mirko.ubaciUListu(o.unosEvidencijeZaSveRacunare());
			}
			if(odluka.equals("2")) {
				EvidencijaRacunara e3 = Serviser.pretragaPoEvidencionomBroju();
				
				Long cena = ProveraExceptiona.proveraBrojaLongZaCenuS("Unesite cenu servisa: ");
				e3.getNaplataServisa().setIznos(cena);
				
			}
			if(odluka.equals("3")) {
				Naplata.placanjeServisa();
			}
			if(odluka.equals("4")) {
				Naplata.zarada();
			}
			if(odluka.equals("5")) {
				mirko.prikazInformacijaZaSveRacunare();
			}
			if(odluka.equals("6")) {
				mirko.prikazInformacijaZaSveRacunarePoTipu();
			}
			if(odluka.equals("7")) {
				mirko.prikazInformacijaZaSveRacunarePoStatusu();
			}
			if(odluka.equals("8")) {
				mirko.promenaStatusaUPriprema();
			}
			if(odluka.equals("9")) {
				mirko.promenaStatusaUPreuzet();
			}
			if(odluka.equals("10")) {
				Txt.napraviTXTzaUredjaje();
			}
			if(odluka.equals("11")) {
				Txt.napraviTXTzaUredjajeUJednomFajlu();
			}
			if(odluka.equals("12")) {
				Txt.napraviTXTzaUredjajeToTipu();
			}
			if(odluka.equals("13")) {
				mirko.ubaciUListu(Txt.napraviTXTzaNovUnetiRacunar());
			}
			
			
		}while(prikaz == true);
	
		
	}
}
