package io01;

import java.io.File;

/**
 * Lokale Pfade einfach beschrieben mit dem package 'io' und der Klasse File
 * 
 * 
 * Lokale Pfade besser beschrieben in dem Package 'nio' und den Klassen Path,
 * Paths, Files. Dazu im nächsten Themenblock mehr.
 * 
 * 
 */
public class Demo01File {

	public static void main(String[] args) {
		/**
		 * Absoluten- und Relativen Pfad
		 */

		/**
		 * relative Pfadangaben
		 * 
		 * (relativ zum aktuellen Arbeitsverzeichnis/Projektverzeichnis)
		 * 
		 * Immer ohne Wurzel Element '/' oder 'c:\\' bzw. 'c:/'
		 * 
		 */
		File ref01 = new File("testfiles/subdir01");//Unix Notation
		File ref02 = new File("testfiles\\subdir02");//Windows Notation
		File ref03 = new File("./test.txt");//Aktuelles Arbeitsverzeichnis
		File ref04 = new File("../");//Ein Verzeichnis nach oben
		File ref05 = new File("abc/fgh");//Eventuell vorhanden oder nicht
		
		
		/**
		 * relative Pfadangaben in der Ausgabe
		 */
		System.out.println("relative Pfadangaben in der Ausgabe");
		System.out.println(ref01);//testfiles\subdir01
		System.out.println(ref02);//testfiles\subdir01
		System.out.println("ref03.exists() : " + ref03.exists());//.
		System.out.println(ref03);//.\test.txt
		System.out.println(ref04);//..
		System.out.println(ref05);//abc\fgh
		
		/**
		 * absolute Pfadangaben
		 */
		File ref06 = new File("/abc/def");//Unix Notation
		File ref07 = new File("c:\\abc\\def");//Windows Notation
		File ref08 = new File("c:/abc/def/../ghi");//Windows Notation
		//ref08 -> c:\abc\ghi
		
		/**
		 * absolute Pfadangaben in der Ausgabe
		 */
		System.out.println("absolute Pfadangaben in der Ausgabe");
		System.out.println(ref06);
		System.out.println(ref07);
		System.out.println(ref08);
		
		/**
		 * getAbsolute können wir uns den Absoluten Pfad anzeigen lassen.
		 */
		System.out.println("getAbsolute");
		System.out.println("ref01 : " + ref01.getAbsolutePath());
		System.out.println("ref02 : " + ref02.getAbsolutePath());
		System.out.println("ref03 : " + ref03.getAbsolutePath());
		System.out.println("ref04 : " + ref04.getAbsolutePath());
		System.out.println("ref05 : " + ref05.getAbsolutePath());
		System.out.println("ref06 : " + ref06.getAbsolutePath());
		System.out.println("ref07 : " + ref07.getAbsolutePath());
		System.out.println("ref08 : " + ref08.getAbsolutePath());
	}

}
