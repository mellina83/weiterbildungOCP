package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Path ist das Interface, womit wir uns einen Pfad bilden k�nnen. Wird als
 *       Referenzdatentyp verwendet
 * 
 * @Paths This class consists exclusively of static methods that return a Path
 *        by converting a path string or URI.
 * 
 * @get(String) get(String first, String... more) Converts a path string, or a
 *              sequence of strings that when joined form a path string, to a
 *              Path. If 'more' does not specify any elements then the value of
 *              the first parameter is the path string to convert. If more
 *              specifies one or more elements then each non-empty string,
 *              including first, is considered to be a sequence of name elements
 *              (see Path) and is joined to form a path string. The details as
 *              to how the Strings are joined is provider specific but typically
 *              they will be joined using the name-separator as the separator.
 *              For example, if the name separator is"/" and
 *              getPath("/foo","bar","gus") is invoked, then the path string
 *              "/foo/bar/gus" is converted to a Path. A Path representing an
 *              empty path is returned if first is the empty string and more
 *              does not contain any non-empty strings.
 */
public class Demo01Path_und_Paths {

	public static void main(String[] args) {
		Path p01;// Einzeln unsinnig

		/**
		 * Eine referenz von Paths ist sinnlos, Konstruktor der Klasse ist Private. Die
		 * Klasse bietet lediglich 2 Statische Methoden zum bilden von Path instanzen.
		 */
		Paths p02;

		/**
		 * Path ist ein Interface und beschreibt einen Pfad.
		 * 
		 * Zum instanzieren ben�tigen wir die UtilityKlasse Paths.
		 * 
		 * Die Paths Klasse hat eine get methode, welche wir verwenden werden
		 */
		Path p03 = Paths.get("a/b/c");
		System.out.println(p03);

		/**
		 * Relative Pfadangaben zum Aktuellen Arbeitsverzeichnis
		 */
		Path p04 = Paths.get("testfiles/subdir");// Unix-Notation
		Path p05 = Paths.get("testfiles\\subdir");// Windows-Notation
		System.out.println(p04);
		System.out.println(p05);

		/**
		 * Absolute Pfadangaben
		 */
		Path p06 = Paths.get("/testfiles/subdir"); // Unix-Notation
		System.out.println(p06);
		Path p07 = Paths.get("c:\\testfiles\\subdir"); // Windows-Notation
		System.out.println(p07);

		/**
		 * Die get Methode der Paths Klasse ist als varArgs realisiert.
		 * 
		 * Die Argumente werden zu einen Path zusammengelegt, wobei der NameSeparator
		 * vom Filesystem Provider bestimmt wird
		 */
		p01 = Paths.get("a", "b", "c");
		System.out.println("1: " + p01);// W: a\b\c U: a/b/c
		
		p01 = Paths.get("e:","a/b", "c");
		System.out.println("2: " + p01);// W: e:\a\b\c U: /a/b/c
		
		p01 = Paths.get("a\\b", "c");
		System.out.println("3: " + p01);// W: a\b\c U: a\b/c - Unsch�ne Pfad in *nix
	}

}
