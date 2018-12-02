package racunar;

public class LapTop extends Racunar{

	private Integer velicinaDispleja;

	public LapTop(String serijskiBroj, Integer brzinaProcesora, String markaRacunar, Integer velicinaDispleja) {
		super(serijskiBroj, brzinaProcesora, markaRacunar);
		this.velicinaDispleja = velicinaDispleja;
	}
	
	@Override
	public String informacijeORacunaru() {
		return "__Informacije o LapTopu__" + "\nSerijski broj: " + getSerijskiBroj() + "\nbrzina procesora: " + getBrzinaProcesora() 
		+ "\nmarka racunara: " + getMarkaRacunar() + "\nvelicina displeja" + getVelicinaDispleja() + "\n";
	}
	
//get//set
	public Integer getVelicinaDispleja() {
		return velicinaDispleja;
	}

	public void setVelicinaDispleja(Integer velicinaDispleja) {
		this.velicinaDispleja = velicinaDispleja;
	}
	
	
	
}
