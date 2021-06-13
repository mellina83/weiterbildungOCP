package pattern.decorator;

import java.time.LocalDate;

public abstract class Vertrag {
	private LocalDate vertragsbeginn = LocalDate.of(2021, 2, 12);
	private LocalDate vertragsende;
	private boolean freigeben;
	
	public LocalDate getVertragsbeginn() {
		return vertragsbeginn;
	}
	public void setVertragsbeginn(LocalDate vertragsbeginn) {
		this.vertragsbeginn = vertragsbeginn;
	}
	public boolean isFreigeben() {
		return freigeben;
	}
	public void setFreigeben(boolean freigeben) {
		this.freigeben = freigeben;
	}
	public LocalDate getVertragsende() {
		return vertragsende;
	}
	public void setVertragsende(LocalDate vertragsende) {
		this.vertragsende = vertragsende;
	}
	
	public abstract void freigeben();
	
	public abstract void kuendigen(LocalDate kuendigungsdatum);
	
}
