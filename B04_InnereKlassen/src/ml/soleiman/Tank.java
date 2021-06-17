package ml.soleiman;

public class Tank {
	
	private int maxVolumen;
	private int tankinhalt;
	private FuellstandSensor fuellstandSensor;
	
	public Tank(int volumen) {
		this.maxVolumen = volumen;
	}

	public void anmeldenFuellstandSensor(FuellstandSensor fuellstandSensor) {
		this.fuellstandSensor = fuellstandSensor;
	}

	public int fuellen() {
//		if(maxVolumen>tankinhalt) {
			fuellstandSensor.meldeFuellstand(tankinhalt, maxVolumen);
			tankinhalt++;
//		}
		return tankinhalt;
	}

	

	
}
