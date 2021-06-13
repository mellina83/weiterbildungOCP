package pattern.decorator;

import java.time.LocalDate;

public class Kaufvertrag extends Vertrag {

	@Override
	public void freigeben() {
		this.setFreigeben(istGueltigIrgendeineLogik());
		System.out.println("Kaufvertrag freigegeben");
	}

	@Override
	public void kuendigen(LocalDate kuendigungsdatum) {
		if(kuendigungsdatum.isAfter(this.getVertragsbeginn())) {
			this.setVertragsende(kuendigungsdatum);
		}
	}
	
	public boolean istGueltigIrgendeineLogik() {
		return true;
	}

}
