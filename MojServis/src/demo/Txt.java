package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import racunar.Desktop;
import racunar.LapTop;
import serviser.EvidencijaRacunara;
import serviser.Serviser;

public class Txt {

	public static void napraviTXTzaUredjaje () throws IOException{
		
		for(int i = 0; i < Serviser.getListaRacunara().size(); i++) {
			BufferedWriter ispis = new BufferedWriter(new FileWriter("C:\\Users\\A\\eclipse-workspace\\MojServis\\src\\Txt\\"
		+ Serviser.getListaRacunara().get(i).getEvidencioniBroj() + ".txt"));
			
			ispis.write(Serviser.getListaRacunara().get(i).informacijeOEvidenciji());
			ispis.newLine();
			ispis.write(Serviser.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
			ispis.newLine();
			ispis.write(Serviser.getListaRacunara().get(i).getNaplataServisa().informacijeONaplati());
			ispis.newLine();
			ispis.close();
		}
	}
	
	
	public static void napraviTXTzaUredjajeUJednomFajlu () throws IOException {
		
		BufferedWriter ispis2 = new BufferedWriter(new FileWriter("C:\\Users\\A\\eclipse-workspace\\MojServis\\src\\Txt\\MojiRacunari.txt"));
		for(int i = 0; i < Serviser.getListaRacunara().size(); i++) {
			
			
			ispis2.write(Serviser.getListaRacunara().get(i).informacijeOEvidenciji());
			ispis2.newLine();
			ispis2.write(Serviser.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
			ispis2.newLine();
			ispis2.write(Serviser.getListaRacunara().get(i).getNaplataServisa().informacijeONaplati());
			ispis2.newLine();
		}
		ispis2.close();
	}
	
	public static void napraviTXTzaUredjajeToTipu () throws IOException {
		BufferedWriter ispis4 = new BufferedWriter(new FileWriter("C:\\Users\\A\\eclipse-workspace\\MojServis\\src\\Txt\\"
				+ "SVI LAPTOP UREDJAJI NA SERVISU" + ".txt"));
		
		BufferedWriter ispis5 = new BufferedWriter(new FileWriter("C:\\Users\\A\\eclipse-workspace\\MojServis\\src\\Txt\\"
				+ "SVI DESKTOP UREDJAJI NA SERVISU" + ".txt"));
		
		for(int i = 0; i < Serviser.getListaRacunara().size(); i++) {
			if(Serviser.getListaRacunara().get(i).getRacunarNaServisu() instanceof LapTop) {
				
				ispis4.write(Serviser.getListaRacunara().get(i).informacijeOEvidenciji());
				ispis4.newLine();
				ispis4.write(Serviser.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
				ispis4.newLine();
				ispis4.write(Serviser.getListaRacunara().get(i).getNaplataServisa().informacijeONaplati());
				ispis4.newLine();
					
				
			}else if(Serviser.getListaRacunara().get(i).getRacunarNaServisu() instanceof Desktop) {
				
				ispis5.write(Serviser.getListaRacunara().get(i).informacijeOEvidenciji());
				ispis5.newLine();
				ispis5.write(Serviser.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
				ispis5.newLine();
				ispis5.write(Serviser.getListaRacunara().get(i).getNaplataServisa().informacijeONaplati());
				ispis5.newLine();
				
				
			}
		}
		ispis4.close();
		ispis5.close();
	}
	
	public static EvidencijaRacunara napraviTXTzaNovUnetiRacunar () throws IOException {
		
			Odluka1 od = new Odluka1();
			EvidencijaRacunara ee = od.unosEvidencijeZaSveRacunare();
		
			BufferedWriter ispis3 = new BufferedWriter(new FileWriter("C:\\Users\\A\\eclipse-workspace\\MojServis\\src\\Txt\\" 
					+ ee.getEvidencioniBroj() + ".txt"));
		
			ispis3.write(ee.informacijeOEvidenciji());
			ispis3.newLine();
			ispis3.write(ee.getRacunarNaServisu().informacijeORacunaru());
			ispis3.newLine();
			ispis3.write(ee.getNaplataServisa().informacijeONaplati());
			ispis3.newLine();
		
			ispis3.close();
		
			return ee;
	}
	
}
