package data;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class Utility {
	
	public static Supplier<String> errorMessage = () -> "ACHTUNG KEINE MELDUNG ERHALTEN"; 

	public static int intAscendingCompare(int x,int y) {
		return Integer.compare(x, y);
	}
	
	public static int intDescendigCompare(int x,int y) {
		return Integer.compare(y, x);
	}
	
	/**
	 * Der übergebene Integer Parameter wird im Vorzeichen umgekehrt.
	 * @param t Umzukehrende Integer Instanz 
	 * @return Vorzeichen Umgekehrte Instanz
	 */
	public static Integer inversion(Integer t) {
		return -t;
	}
	
	

	public static <T> void useSupplier(Supplier<T> supplier) {
		System.out.println("Methode die einen Supplier entgegen nimmt");
//		T t = new T();
		T t = supplier.get();
		System.out.println("Instanz aus dem Supplier " + t.toString());
		System.out.println("t.getClass() = " + t.getClass());
	}
	
	
	public static void befuellen(List<Integer> list) {
		Random random = new  Random(System.currentTimeMillis());
		for(int i = 0;i<256;i++) {
			//list.add(random.nextInt(10_000)+1);//von 1 - 10_000
			list.add(random.nextInt(100)+1);//von 1 - 100
		}
	}

	public static void fillMap(Map<Integer,String> map) {
		map.put(1, "Hallo");
		map.put(2, "Welt");
		map.put(3, "Hier");
		map.put(4, "ist");
		map.put(5, "Java");
		map.put(6, "Lambda");
		map.put(7, "DateTimeApi");
		map.put(8, "Streams");
		map.put(11, "er");
		map.put(12, "ah");
		map.put(14, "ml");
	}
	
	public static void printMyMap(Map<Integer,String> map) {
		map.forEach(Utility::printMyMap);
	}
	
	public static void printMyMap(Integer key, String value) {
		System.out.println(key + " : " + value);
	}
}
