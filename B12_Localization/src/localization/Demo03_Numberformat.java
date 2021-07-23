package localization;

import java.text.NumberFormat;
import java.util.Locale;

public class Demo03_Numberformat {
	public static void main(String[] args) {
		/*
		 * NumberFormat is the abstract base class for all number formats. This class
		 * provides the interface for formatting and parsing numbers. NumberFormat also
		 * provides methods for determining which locales have number formats, and what
		 * their names are.
		 */
		NumberFormat formatter01 = NumberFormat.getCurrencyInstance();

		// Mit default Locale
		String geldBetrag01 = formatter01.format(45.775);
		System.out.println("geldBetrag01: " + geldBetrag01);

		NumberFormat formatter02 = NumberFormat.getNumberInstance();
		String kommazahl01 = formatter02.format(99.999);
		System.out.println("kommazahl01: " + kommazahl01);

		// Mit speziellem Locale
		NumberFormat formatter03 = NumberFormat.getCurrencyInstance(Locale.UK);
		String geldBetrag02 = formatter03.format(45.775);
		System.out.println("geldBetrag02: " + geldBetrag02);

		NumberFormat formatter04 = NumberFormat.getNumberInstance(Locale.US);
		String kommazahl02 = formatter04.format(99.999);
		System.out.println("kommazahl02: " + kommazahl02);

	}
}
