package pattern.factory;

enum CarType{ VW,AUDI,NISSAN,FERRARI}

public class CarFactory {
	
	public static Vehicle getVehicle(CarType type) {
		Vehicle vehicle = null;
		
		switch(type) {
		case VW: 
			vehicle = new Car(4, 60	, 1199);
			break;
		case AUDI: 
			vehicle = new Car(4, 112, 1790);
			break;
		case NISSAN: 
			vehicle = new Car(4, 114, 1690);
			break;
		case FERRARI: 
			vehicle = new Car(4, 520, 4699);
			break;
		}
		
		return vehicle;
	}
	
}
