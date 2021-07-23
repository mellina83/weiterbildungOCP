package localization;

import java.util.ResourceBundle;

public class Demo06_ResourceBundle_mitKlassen {
	public static void main(String[] args) {
		String basename = "localization.Animal";
		ResourceBundle bundle = ResourceBundle.getBundle(basename);
		
		System.out.println(bundle.getString("animal-stock-label") + " : Schweinchen");
		System.out.println(bundle.getString("animal-color-label") + " : Rosa");
		
		Object o = bundle.getObject("object");
		System.out.println(o.getClass().getSimpleName());
	}
}
