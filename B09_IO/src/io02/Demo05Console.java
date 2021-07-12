package io02;

import java.io.Console;

/**
 * Läuft nicht in eclipse
 * 
 * muss aus dem Source ordner unter /bin gestartet werden.
 * 
 * Start mit java -cp . io02/Demo05Console
 *
 */
public class Demo05Console {

	public static void main(String[] args) {
		Console console = System.console();
		
		String name = "Console";
		console.format("Hallo %s %n", name);
		console.printf("Hallo %s %n", name);

		String userName = console.readLine("Bitte %s Namen eingeben: ", "deinen");
		console.format("Danke, %s! %n", userName);
		
		String password = "Hugeldubel";
		char[] pwd = console.readPassword("Bitte Passwort eingeben: ");
		
		console.format("Das Passwort hat %d Zeichen.%n", pwd.length);
		console.format("Password = " + String.valueOf(pwd));
	}

}
