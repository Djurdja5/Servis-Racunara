package racunar;

public class Desktop extends Racunar{

	private TipKucista tipKucista;

	public Desktop(String serijskiBroj, Integer brzinaProcesora, String markaRacunar, TipKucista tipKucista) {
		super(serijskiBroj, brzinaProcesora, markaRacunar);
		this.tipKucista = tipKucista;
	}

	@Override
	public String informacijeORacunaru() {
		return "__Informacije o Desktopu__" + "\nSerijski broj: " + getSerijskiBroj() + "\nbrzina procesora: " + getBrzinaProcesora() + 
				"\nmarka racunara: " + getMarkaRacunar() + "\ntip kucista: " + getTipKucista() + "\n";
	}
		
//get//set
	public TipKucista getTipKucista() {
		return tipKucista;
	}

	public void setTipKucista(TipKucista tipKucista) {
		this.tipKucista = tipKucista;
	}
	
	
}
