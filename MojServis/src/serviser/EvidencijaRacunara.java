package serviser;

import java.time.LocalDate;

import racunar.Racunar;

public class EvidencijaRacunara {

	private String evidencioniBroj;
	private String vlasnik;
	private Racunar racunarNaServisu;
	private Status statusServisa;
	private LocalDate datumPrijema;
	private LocalDate datumZavrsetka;
	private Naplata naplataServisa;

	public EvidencijaRacunara(String evidencioniBroj, String vlasnik, Racunar racunar, Status statusServisa, Integer brojDana) {
		super();
		this.evidencioniBroj = evidencioniBroj;
		this.vlasnik = vlasnik;
		this.racunarNaServisu = racunar;
		this.statusServisa = statusServisa;
		this.datumPrijema = LocalDate.now();
		this.datumZavrsetka = LocalDate.now().plusDays(brojDana);
		this.naplataServisa = new Naplata();
	}
		
	public EvidencijaRacunara(String evidencioniBroj, String vlasnik, Racunar racunar) {
		super();
		this.evidencioniBroj = evidencioniBroj;
		this.vlasnik = vlasnik;
		this.racunarNaServisu = racunar;
		this.statusServisa = Status.PRIJEM;
		this.datumPrijema = LocalDate.now();
		this.naplataServisa = new Naplata(); //*
	}
	


	public String informacijeOEvidenciji () {
		return "Evidencioni broj: " + getEvidencioniBroj() + "\nVasnik racunara: " + getVlasnik() + "\nRacunar je u statusu: " + getStatusServisa()
		+ "\nDatum prijema racunara: " + getDatumPrijema() + "\nDatum zavrsetka racunara: " + getDatumZavrsetka() + "\n ";
	}
	
//get//set	
	public String getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}
	public LocalDate getDatumPrijema() {
		return datumPrijema;
	}
	public void setDatumPrijema(LocalDate datumPrijema) {
		this.datumPrijema = datumPrijema;
	}
	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	public String getEvidencioniBroj() {
		return evidencioniBroj;
	}
	public void setEvidencioniBroj(String evidencioniBroj) {
		this.evidencioniBroj = evidencioniBroj;
	}
	public Status getStatusServisa() {
		return statusServisa;
	}
	public void setStatusServisa(Status statusServisa) {
		this.statusServisa = statusServisa;
	}
	public Naplata getNaplataServisa() {
		return naplataServisa;
	}
	public void setNaplataServisa(Naplata naplataServisa) {
		this.naplataServisa = naplataServisa;
	}
	public Racunar getRacunarNaServisu() {
		return racunarNaServisu;
	}
	public void setRacunarNaServisu(Racunar racunarNaServisu) {
		this.racunarNaServisu = racunarNaServisu;
	}
	
	
}
