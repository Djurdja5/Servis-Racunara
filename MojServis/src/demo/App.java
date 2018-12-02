package demo;

import java.util.Scanner;

import racunar.Desktop;
import racunar.LapTop;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Naplata;
import serviser.Serviser;
import serviser.Status;

public class App {

	public static void main(String[] args) {
		
		
		Serviser mirko = new Serviser();
		
		EvidencijaRacunara er1 = new EvidencijaRacunara("5b", "Isidora", new LapTop("2222", 2000, "Dell", 18), Status.PRIJEM, 3);
		EvidencijaRacunara er2 = new EvidencijaRacunara("3b", "Nemanja", new Desktop("9999", 1500, "Toshida", TipKucista.ATX), Status.PRIJEM, 9);

		er1.getNaplataServisa().setIznos(2000L);
		er1.getNaplataServisa().setPlaceno(true);
		
		er2.getNaplataServisa().setIznos(3000L);
		
		mirko.ubaciUListu(er1);
		mirko.ubaciUListu(er2);
		
		System.out.println("Promet: ");
		mirko.zarada(); // posle ubacivanja u listu
		//Naplata.zarada();

		for(int i = 0; i < mirko.getListaRacunara().size(); i++) {
			System.out.println(mirko.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
		}

		mirko.promenaStatusaUPreuzet(); //
		mirko.prikazInformacijaZaSveRacunare();
		
		System.out.println("");
		System.out.println("***unos preko komandi***");
		System.out.println("");
		
		boolean prikaz = true;
		
		do {
			System.out.println("");
			System.out.println("Izaberite opciju: ");
			System.out.println("0 - za izlaz iz aplikacije");
			System.out.println("1 - za unos novog racunara");
			System.out.println("2 - za unos cene servisa");
			System.out.println("3 - za placanje servisa");
			System.out.println("4 - za prikaz svih uredjaja na servisu");
			System.out.println("5 - za prikaz uredjaja na servisu po tipu ");
			System.out.println("6 - za prikaz uredjaja na servisu po statusu");
			System.out.println("7 - za prikaz zarade");
			
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
				boolean objekatNePostoji = true; 
				
				do {
					System.out.println("Unesite evidencioni broj: ");
					String eBr = new Scanner(System.in).nextLine(); 
					
					for(int i  = 0; i < mirko.getListaRacunara().size(); i++) {
						if(mirko.getListaRacunara().get(i).getEvidencioniBroj().equals(eBr)) {
							Long cena = ProveraExceptiona.proveraBrojaLongZaCenuS("Unesite cenu servisa: ");
							mirko.getListaRacunara().get(i).getNaplataServisa().setIznos(cena);

							objekatNePostoji = false; 
						}
					}
					if (objekatNePostoji == true) {
						System.err.println("Racunar sa ovim evidencionim brojem ne postoji na servisu! Pokusajte ponovo!");	
					}
					
				}while(objekatNePostoji == true);
					
				
			}
			if(odluka.equals("3")) {
				mirko.placanjeServisa();
			}
			if(odluka.equals("4")) {
				mirko.prikazInformacijaZaSveRacunare();
			}
			if(odluka.equals("5")) {
				mirko.prikazInformacijaZaSveRacunarePoTipu();
			}
			if(odluka.equals("6")) {
				mirko.prikazInformacijaZaSveRacunarePoStatusu();
			}
			if(odluka.equals("7")) {
				mirko.zarada();
				//Naplata.zarada();
			}
			
		}while(prikaz == true);
	
		
	}
}
