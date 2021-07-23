package localization;

import java.util.ResourceBundle;

public class Demo08_ResourceBundle_Exam {
	
	public void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("localization.Exam");
		
		bundle.keySet().stream().sorted().forEach(key -> {
			String value = bundle.getString(key);
			System.out.println(key + " = " + value);			
		});

		/*
		 * Die lokale Variable muss final oder effectively final sein
		 */
//		bundle = ResourceBundle.getBundle("localization.MyAppText");

	}
}
