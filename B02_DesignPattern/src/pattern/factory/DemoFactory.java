package pattern.factory;

import java.time.LocalDate;

public class DemoFactory {
	public static void main(String[] args) {
//		LocalDate date1 = new LocalDate();
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2012, 10, 10);
		
		
		Vehicle vehicle1 = CarFactory.getVehicle(CarType.VW);
		Vehicle vehicle2 = CarFactory.getVehicle(CarType.FERRARI);
		
		System.out.println(vehicle1);
		System.out.println(vehicle2);
		
		
	}
}
