package pattern.mvc_observer;

public class Model {
	private int zahl;

	public int getZahl() {
		return zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;
	}
	
	public int countUp() {
		System.out.println("Model counting up");
		this.setZahl(this.getZahl()+1);
		return this.getZahl();
	}
	public int countDown() {
		System.out.println("Model counting down");
		this.setZahl(this.getZahl()-1);
		return this.getZahl();
	}
}
