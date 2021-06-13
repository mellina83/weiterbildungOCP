package pattern.factory;

public class Car implements Vehicle {

	private int wheel;
	private int horsePower;
	private int ccm;

	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public int getCcm() {
		return ccm;
	}
	public void setCcm(int ccm) {
		this.ccm = ccm;
	}

	public Car(int wheel, int horsePower, int ccm) {
		this.setWheel(wheel);
		this.setHorsePower(horsePower);
		this.setCcm(ccm);
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Car [wheel=" + wheel + ", horsePower=" + horsePower + ", ccm=" + ccm + "]";
	}
	


}
