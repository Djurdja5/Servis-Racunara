package racunar;

public abstract class Racunar {

	private String serijskiBroj;
	private Integer brzinaProcesora;
	private String markaRacunar;
	
	public Racunar(String serijskiBroj, Integer brzinaProcesora, String markaRacunar) {
		super();
		this.serijskiBroj = serijskiBroj;
		this.brzinaProcesora = brzinaProcesora;
		this.markaRacunar = markaRacunar;
	}

	public abstract String informacijeORacunaru();
	
//get//set	
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}
	public Integer getBrzinaProcesora() {
		return brzinaProcesora;
	}
	public void setBrzinaProcesora(Integer brzinaProcesora) {
		this.brzinaProcesora = brzinaProcesora;
	}
	public String getMarkaRacunar() {
		return markaRacunar;
	}
	public void setMarkaRacunar(String markaRacunar) {
		this.markaRacunar = markaRacunar;
	}
	
	
	
}
