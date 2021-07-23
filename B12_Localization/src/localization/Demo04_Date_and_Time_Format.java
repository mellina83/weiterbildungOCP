package localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Demo04_Date_and_Time_Format {
	
	/*
	 * Fuer den Fall, dass es in der Pruefung noch auftaucht
	 */
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println(date1);
		
		/*
		 * DateFormat mit default Locale
		 */
		DateFormat formatter01 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL);
		String defaultDate = formatter01.format(date1);
		System.out.println("defaultDate: " + defaultDate);
		
		/*
		 * DateFormat mit speziellem Locale
		 */
		DateFormat formatter02 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.FRANCE);
		String specifiedDate = formatter02.format(date1);
		System.out.println("specifiedDate: " + specifiedDate);
		
		
		
	}
}
