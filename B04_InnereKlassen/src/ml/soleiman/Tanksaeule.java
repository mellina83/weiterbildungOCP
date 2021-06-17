package ml.soleiman;

public class Tanksaeule {
	
	private Tank tank;
	public boolean stopFuellen;
	
	public Tanksaeule() {
		
	}
	public void tankstutzenEntnehmen (Tank tank) {
		this.stopFuellen = false;
		this.tank = tank;
	}
	public void startTanken() {
		FuellstandSensor fs = new FuellstandSensor() {			
			@Override
			public void meldeFuellstand(int fuellstand, int maxVolumen) {
				stopFuellen = fuellstand >= maxVolumen;
				System.out.println("Fuellstand: " + fuellstand);
			}
		};
		this.tank.anmeldenFuellstandSensor(fs);
		
		while(!stopFuellen) {
			this.tank.fuellen();			
		}
	}
}
