package serviser;

import java.util.ArrayList;
import java.util.Scanner;
import racunar.Desktop;
import racunar.LapTop;

public class Serviser {

	private static ArrayList<EvidencijaRacunara> listaRacunara;

	public Serviser() {
		Serviser.listaRacunara = new ArrayList<>();
	}

	
	// DODELJIVANJE SERVISERU RACUNAR
	public void ubaciUListu (EvidencijaRacunara er) {
		listaRacunara.add(er);
	}
	
	
	// UKLANJANJE SERVISERU RACUNAR
	public void ukloniIzListe (EvidencijaRacunara stigoRacunar) {
		listaRacunara.remove(stigoRacunar);
	}
	
	
	// PRIKAZ INFORMACIJA
	public void prikazInformacijaZaSveRacunare () {
		for(int i = 0; i < listaRacunara.size(); i++) {
			System.out.println(listaRacunara.get(i).getRacunarNaServisu().informacijeORacunaru());
			System.out.println(listaRacunara.get(i).informacijeOEvidenciji());
			System.out.println(listaRacunara.get(i).getNaplataServisa().informacijeONaplati());  
		}
	}
	
	
	// PRIKAZ INFORMACIJA PO TIPU (LAPTOP / DESKTOP)
	public void prikazInformacijaZaSveRacunarePoTipu () {
		System.out.println("Unesite L za LapTop, D za Desktop");
		String tipRacunara = new Scanner(System.in).nextLine().toUpperCase();
		
		if(tipRacunara.equals("L")) {
			for(int i = 0; i < getListaRacunara().size(); i++) {
				if(getListaRacunara().get(i).getRacunarNaServisu() instanceof LapTop) {
					System.out.println(getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
					System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
				}
			}
		}else if(tipRacunara.equals("D")) {
			for(int i = 0; i < getListaRacunara().size(); i++) {
				if(getListaRacunara().get(i).getRacunarNaServisu() instanceof Desktop) {
					System.out.println(getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
					System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
				}
			}
		}else {
			System.out.println("Unos je pogresan!");
		}
	}
	
	
	// METODA ZA SKRACENJE KODA SVAKE DRUGE METODE KOJA PROVERAVA PREKO EVIDENCIONOG BROJA - UKOLIKO POSTOJI VRACA KONKRETAN OBJEKAT (lista static)
	public static EvidencijaRacunara pretragaPoEvidencionomBroju() {
		
		boolean ponovo = true;
		
		do {	
			System.out.println("Unesite evidencioni broj: ");
			String eBroj = new Scanner(System.in).nextLine();
			boolean objekatNePostoji = true;
		
			for(int i = 0; i < getListaRacunara().size(); i++) {
				if (getListaRacunara().get(i).getEvidencioniBroj().equals(eBroj)) {
					objekatNePostoji = false;
					ponovo = false;   //*
					return getListaRacunara().get(i);  //**
				
				}
			}if(objekatNePostoji == true) 
				System.err.println("Racunar sa evidencionim brojem " + eBroj + " ne postoji na servisu! Pokusajte ponovo!");
		
		}while(ponovo == true);
		
	return null;
		
	}
	

	
	// MENJA STATUS RACUNARA PO EVIDENCIONOM BROJ U PRIPREMA
	public void promenaStatusaUPriprema () {
		
		EvidencijaRacunara e = pretragaPoEvidencionomBroju(); 
		
		e.setStatusServisa(Status.PRIPREMA); //**
			
	}
	

	// MENJA STATUS RACUNARA PO EVIDENCIONOM BROJ U PREUZET
	public void promenaStatusaUPreuzet () {
		EvidencijaRacunara e2 = pretragaPoEvidencionomBroju(); 
		
		if(e2.getNaplataServisa().getPlaceno() == true) { 
			e2.setStatusServisa(Status.PREUZET);
		}else {
			System.err.println("Ne mozete preuzeti racunar dok dok ne platite racun!");
		}
		
	}
	
	
	//PRIKAZ INFORMACIJA PO STATUSU
	public void prikazInformacijaZaSveRacunarePoStatusu () {
		boolean b = true;
		while(b == true) {
			System.out.println("1 - Prijem");
			System.out.println("2 - Priprema");
			System.out.println("3 - Zavrsen");
			System.out.println("4 - Preuzet");
			System.out.println("0 - Povratak na prethodni meni");
			System.out.println("Unesite opciju za prikaz uredjaja po statusu: ");
			
			String brojOdluke = new Scanner(System.in).nextLine();
			
			for(int i = 0; i < getListaRacunara().size(); i++) {
				if(brojOdluke.equals("1")) {
					if(getListaRacunara().get(i).getStatusServisa().equals(Status.PRIJEM)) {
						System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
					}
				}else if(brojOdluke.equals("2")) {
					if(getListaRacunara().get(i).getStatusServisa().equals(Status.PRIPREMA)) {
						System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
					}
				}else if(brojOdluke.equals("3")) {
					if(getListaRacunara().get(i).getStatusServisa().equals(Status.ZAVRSEN)) {
						System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
					}
				}else if(brojOdluke.equals("4")) {
					if(getListaRacunara().get(i).getStatusServisa().equals(Status.PREUZET)) {
						System.out.println(getListaRacunara().get(i).informacijeOEvidenciji());
					}
				}else if(brojOdluke.equals("0")) {
					b = false;
				}else 
					System.err.println("Uneli ste pogresan status!");
				
				}
			}
		}	
	
	
	
	public void lapTopRacunariNaServisu () {
		
	}
		
//get//set
	
//	public ArrayList<EvidencijaRacunara> getListaRacunara() {
//		return listaRacunara;
//	}
//
//	public void setListaRacunara(ArrayList<EvidencijaRacunara> listaRacunara) {
//		this.listaRacunara = listaRacunara;
//	}
	
	public static ArrayList<EvidencijaRacunara> getListaRacunara() {
		return listaRacunara;
	}

	public static void setListaRacunara(ArrayList<EvidencijaRacunara> listaRacunara) {
		Serviser.listaRacunara = listaRacunara;
	}
	
	
			
}
