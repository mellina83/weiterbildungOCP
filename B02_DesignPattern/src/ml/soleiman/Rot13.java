package ml.soleiman;
import java.util.Arrays;
import java.util.Scanner;

public class Rot13 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Bitte Text eingeben der nach ROT13 verschlüsselt/entschlüsselt werden soll: ");
		
		String eingabe = sc1.nextLine();
		
		char[] char_arr = eingabe.toCharArray();
		
		for (char chr : char_arr) {
			if ((chr >= 'A') && (chr <= 'Z')) {
				chr += 13;
				if (chr > 'Z')
					chr -= 26;
			} else if ((chr >= 'a') && (chr <= 'z')) {
				chr += 13;
				if (chr > 'z')
					chr -= 26;
			} 
			System.out.print( chr);
		}
	}
}
