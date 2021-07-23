package localization;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Demo06a {
	public static void main(String[] args) {
		String propFile = "localization/MyAppText";
		ResourceBundle bundleFromFile = ResourceBundle.getBundle(propFile);
		
		System.out.println(bundleFromFile.getClass().getSimpleName());
		PropertyResourceBundle bndl1 = (PropertyResourceBundle)bundleFromFile;
		
		
		String classFile = "localization.Animal";
		ResourceBundle bundleFromClass = ResourceBundle.getBundle(classFile);
		System.out.println(bundleFromClass.getClass().getSimpleName());
		
		
	}
}
