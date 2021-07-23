package properties;

import java.util.Map;
import java.util.Properties;

public class Demo01_System_Properties {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		
		for(Map.Entry<Object, Object> entry : prop.entrySet()) {
			System.out.printf("%30s = %s %n", entry.getKey(), entry.getValue());
		}
		
		prop.list(System.out);
		
		System.out.println("\n\n***********************");
		
		String userHome = prop.getProperty("user.home");
		System.out.println("user.home: " + userHome);
		
		String nichtda = prop.getProperty("nichtda");
		System.out.println("nichtda: " + nichtda);
		
		nichtda = prop.getProperty("nichtda", "Standard-Wert");
		System.out.println("nichtda: " + nichtda);
		
		prop.setProperty("myOwnKey---------------", "myOwnValue----------------");
		prop.list(System.out);
		
		
		
	}
}
