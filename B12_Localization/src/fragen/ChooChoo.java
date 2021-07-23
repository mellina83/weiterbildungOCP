package fragen;

import java.util.Locale;
import java.util.ResourceBundle;

//Train_en_US.properties: train=subway
//Train_en_UK.properties: train=underground
//Train_en.properties: ride = ride
public class ChooChoo {
	public static void main(String[] args) {
//		Locale.setDefault(new Locale("en", "US"));
//		Locale.setDefault(new Locale("en", "UK"));
		ResourceBundle rb = ResourceBundle.getBundle("fragen/Train", new Locale("en", "UK"));
		System.out.print(rb.getString("ride") + " " + rb.getString("train"));
	}
}
//Self Test 243
//Which of the following, when made independently, will change the output to "ride underground"?
//(Choose all that apply.)
//A. Add train=underground to Train_en.properties						X
//B. Change line 3 to Locale.setDefault(new Locale("en", "UK"));		X
//C. Change line 5 to Locale.ENGLISH);									X
//D. Change line 5 to new Locale("en", "UK"));							O
//E. Delete file Train_en_US.properties									X
