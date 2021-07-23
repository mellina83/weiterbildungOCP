package localization;

import java.util.ListResourceBundle;

/*
 * ListResourceBundle is an abstract subclass of ResourceBundle that manages 
 * resources for a locale in a convenient and easy to use list. See ResourceBundle 
 * formore information about resource bundles in general. 
 */
public class Animal_de_DE extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"animal-stock-label", "Tierrasse"},
			{"animal-color-label", "Farbe"},
			{"object", new Integer(1234)}
		};
	}

}
