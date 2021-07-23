package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Demo02_Propertie_File {
	public static void main(String[] args) {
		Properties myprops = new Properties();		
		/*
		 * getResourceAsStream arbeitet micht mit Locales
		 */
		try(InputStream is = Demo02_Propertie_File.class.getResourceAsStream("/properties/exam.properties")){
			myprops.load(is);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		myprops.keySet().forEach(key->{
			System.out.println(key + " : " + myprops.getProperty((String)key));
		});
		
		/*
		 * ResourceBundle arbeitet mit den Locales
		 */
		System.out.println("-----------------------------");
		String baseName = "properties.exam";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		bundle.keySet().forEach(key->{
			System.out.println(key + " : " + bundle.getString(key));
		});

	}	
}
