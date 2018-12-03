package racunar;

public class LapTop extends Racunar{

	private Integer velicinaDispleja;

	public LapTop(String serijskiBroj, Integer brzinaProcesora, String markaRacunar, Integer velicinaDispleja) {
		super(serijskiBroj, brzinaProcesora, markaRacunar);
		this.velicinaDispleja = velicinaDispleja;
	}
	
	@Override
	public String informacijeORacunaru() {
		return "-INFORMACIJE O LAPTOPU-" + "\r\nSerijski broj: " + getSerijskiBroj() + "\r\nbrzina procesora: " + getBrzinaProcesora() 
		+ "\r\nmarka racunara: " + getMarkaRacunar() + "\r\nvelicina displeja" + getVelicinaDispleja() + "\r\n";
	}
	
//get//set
	public Integer getVelicinaDispleja() {
		return velicinaDispleja;
	}

	public void setVelicinaDispleja(Integer velicinaDispleja) {
		this.velicinaDispleja = velicinaDispleja;
	}
	
	
	
}
