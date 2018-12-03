package racunar;

public class Desktop extends Racunar{

	private TipKucista tipKucista;

	public Desktop(String serijskiBroj, Integer brzinaProcesora, String markaRacunar, TipKucista tipKucista) {
		super(serijskiBroj, brzinaProcesora, markaRacunar);
		this.tipKucista = tipKucista;
	}

	@Override
	public String informacijeORacunaru() {
		return "-INFORMACIJE O DESKTOPU-" + "\r\nSerijski broj: " + getSerijskiBroj() + "\r\nbrzina procesora: " + getBrzinaProcesora() + 
				"\r\nmarka racunara: " + getMarkaRacunar() + "\r\ntip kucista: " + getTipKucista() + "\r\n";
	}
		
//get//set
	public TipKucista getTipKucista() {
		return tipKucista;
	}

	public void setTipKucista(TipKucista tipKucista) {
		this.tipKucista = tipKucista;
	}
	
	
}
