package properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;



public class Demo03_Klasse_Properties {
	public static void main(String[] args) {
//		writeProperties();
		readProperties();
	}

	private static void readProperties() {
		File file = new File("MyProperties.properties");
		try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
			Properties prop = new Properties();
			prop.load(br);
			Set<Object> alleKeys = prop.keySet();
			alleKeys.forEach(key -> {
				System.out.println(key + " = " + prop.get(key));
			});		
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	private static void writeProperties() {
		File file = new File("MyProperties.properties");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try(FileWriter fw = new FileWriter(file);BufferedWriter bw = new BufferedWriter(fw)){
			Properties prop = new Properties();
			prop.setProperty("db.url", "localhost");
			prop.setProperty("db.user", "username");
			prop.setProperty("db.password", "password");
			
			prop.store(bw, "Ein Kommentar");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
