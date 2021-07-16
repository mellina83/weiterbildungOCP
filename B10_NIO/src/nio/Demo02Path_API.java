package nio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo02Path_API {

	public static void main(String[] args) {
//		pathEquals();
		pathNormalize();

//		pathGetRoot("C:\\WINDOWS\\Installer");// Absolute Pfadangabe
//		pathGetRoot("10_NIO/testfiles");// Relative Pfadangabe
//		pathGetRoot("/10_NIO/testfiles");// Absolute Pfadangabe

//		pathgetFileName("C:\\WINDOWS\\Installer"); // Absolute Pfadangabe
//		pathgetFileName("testfiles/subdir");// Relative Pfadangabe
//		pathgetFileName("/testfiles/subdir"); // Absolute Pfadangabe
//		pathgetFileName("bin/nio/Demo01Path_und_Paths.class"); // Relative Pfadangabe

//		path_getName_getNameCount("C:\\WINDOWS\\Installer");// Absolute Pfadangabe
//		path_getName_getNameCount("C:\\WINDOWS\\diagnostics\\scheduled\\Maintenance\\de-DE\\DiagPackage.dll.mui"); // Absolute Pfadangabe
//		path_getName_getNameCount("bin/nio/Demo01Path_und_Paths.class"); // Relative Pfadangabe
		
//		path_subpath();
		
//		path_startsWith_endsWith();
		
//		path_resolve();
		
//		path_relativize();
		
//		path_toAbsolutePath();
		
//		fileWithPaths();
	}

	private static void fileWithPaths() {
		File file = Paths.get("a","b","c","d").toFile();
		try {
			FileWriter fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void path_toAbsolutePath() {
		System.out.println("\n--------------\n path_toAbsolutePath\n--------------\n");
		
		Path p1 = Paths.get(".");
		System.out.println("p1: " + p1);
		
		Path p2 = p1.toAbsolutePath();
		System.out.println("p2: " + p2);
	}

	/**
	 * EXAM
	 * 
	 * @relativize Constructs a relative path between this path and a given path.
	 * 
	 *             Relativization is the inverse of resolution. This method attempts
	 *             to construct a relative path that when resolved against this
	 *             path, yields a path that locates the same file as the given path.
	 * 
	 *             For example, on UNIX, if this path is "/a/b" and the given path
	 *             is "/a/b/c/d" then the resulting relative path would be "c/d".
	 * 
	 *             Where this path and the given path do not have a root
	 *             component,then a relative path can be constructed.
	 * 
	 *             A relative path cannot be constructed if only one of the paths
	 *             have a root component.
	 * 
	 *             Where both paths have a root component then it is implementation
	 *             dependent if a relative path can be constructed.
	 * 
	 *             If this path and the given path are equal then an empty path is
	 *             returned.
	 */
	private static void path_relativize() {
		System.out.println("\n--------------\n path_relativize\n--------------\n");
		
		/**
		 * Relative Pfade
		 */
		System.out.println("****** a/b/c/d -> a/b/e/f ");
		Path p1 = Paths.get("a/b/c/d");
		Path p2 = Paths.get("a/b/e/f");
		
		Path p3 = p1.relativize(p2);//a/b/c/d -> a/b/e/f
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p3 : " + p3);//../../e/f
		
		/**
		 * Absoluten Pfade
		 */
		System.out.println("****** /a/b/c/d -> /a/b/e/f ");
		p1 = Paths.get("/a/b/c/d");
		p2 = Paths.get("/a/b/e/f");
		p3 = p1.relativize(p2);// /a/b/c/d -> ../../e/f ->/a/b/e/f
		
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p3 : " + p3);//../../e/f
		
		/**
		 * Absolute und Relative Pfade zusammen
		 */
		System.out.println("****** /a/b/c/d -> a/b/e/f ");
		p1 = Paths.get("/a/b/c/d");
		p2 = Paths.get("a/b/e/f");
		
		/**
		 * java.lang.IllegalArgumentException: 'other' is different type of Path
		 */
		//p3 = p2.relativize(p1);
		
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p3 : " + p3);
	}

	/**
	 * EXAM
	 * 
	 * @resolve Converts a given path string to a Path and resolves it against this
	 *          Path in exactly the manner specified by the resolve method.
	 * 
	 *          For example, suppose that the name separator is "/" and a path
	 *          represents "foo/bar", then invoking this method with the path string
	 *          "gus" will result in the Path "foo/bar/gus".
	 */
	private static void path_resolve() {
		System.out.println("\n--------------\n path_resolve\n--------------\n");
		Path basedir = Paths.get("basedir"); // Relativer Arbeitspfad
		
		System.out.println("basedir : " + basedir.toAbsolutePath());
		
		/**
		 * Mit resolve werden die beiden Pfade verschmolzen, bzw. der String als Pfad
		 * angehangen
		 */
		Path subdir = basedir.resolve("subdir");
		System.out.println("subdir : " + subdir.toAbsolutePath());
		
		Path file01 = Paths.get("lorem.txt");
		Path dir = Paths.get("testfiles");
		
		Path dirAndFile = dir.resolve(file01);
		System.out.println("dirAndFile : " + dirAndFile.toAbsolutePath());
		
		/**
		 * Eventueller Fallstrick in der Prüfung, aber eher unwahrscheinlich. Achten Sie
		 * auf Absolute Pfadangaben!!!
		 */
		Path p1 = Paths.get("C:\\Hallo");
		Path p2 = Paths.get("D:\\Welt\\Hier\\Ist\\Java");
		Path p3 = p1.resolve(p2);
		System.out.println("p3 : " + p3);//D:\\Welt\\Hier\\Ist\\Java
	}

	/**
	 * @startsWith Tests if this path starts with a Path, constructed by converting
	 *             the given path string, in exactly the manner specified by the
	 *             startsWith(Path) method.
	 * 
	 *             On UNIX for example, the path"foo/bar" starts with "foo" and
	 *             "foo/bar". It does not start with "f" or "fo".
	 * 
	 */
	private static void path_startsWith_endsWith() {
		System.out.println("\n--------------\n startWith_endsWith\n--------------\n");
		
		// ------------------/0/1/2/3/4/5/6/7
		Path p1 = Paths.get("/h/j/k/l/p/o/i/u");
		System.out.println("p1: " + p1);
		
		String other = "k/l/p";
		System.out.println("p1.startsWith(k/l/p) : " + p1.startsWith(other));//false
		
		other = "/h/j";
		System.out.println("p1.startsWith(/h/j) : " + p1.startsWith(other));//true
		
		p1 = Paths.get("foo/bar/minimum");
		other = "fo";
		System.out.println("p1.startsWith(fo) : " + p1.startsWith(other));//false
		other = "foo";
		System.out.println("p1.startsWith(foo) : " + p1.startsWith(other));//true
		other = "foo/bar/minimum";
		System.out.println("p1.startsWith(foo/bar/minimum) : " + p1.startsWith(other));//true
		
		System.out.println("p1.endsWith(minimum) : " + p1.endsWith("minimum"));//true
		System.out.println("p1.endsWith(bar/minimum) : " + p1.endsWith("bar/minimum"));//true
		System.out.println("p1.endsWith(foo/bar/minimum) : " + p1.endsWith("foo/bar/minimum"));// true
		System.out.println("p1.endsWith(mum) : " + p1.endsWith("mum"));//false
	}

	/**
	 * EXAM
	 * 
	 * @subpath Returns a relative Path that is a subsequence of the name elements
	 *          of this path.
	 */
	private static void path_subpath() {
		System.out.println("\n--------------\n path_subpath\n--------------\n");
		//-------------------/0/1/2/3/4/5/6/7
		Path p1 = Paths.get("/h/j/k/l/p/o/i/u");
		
		System.out.println("p1 = " + p1);//
		
		int beginIndex = 2;// Inklusive
		int endIndex = 6;// Exklusive
		
		Path p2 = p1.subpath(beginIndex, endIndex);
		System.out.println("p2 = " + p2);// k l p o 
	}

	/**
	 * EXAM
	 * 
	 * @getNameCount the number of elements in the path, or 0 if this path only
	 *               represents a root component
	 * 
	 * @getName(int) Returns a name element of this path as a Path object.
	 * 
	 *               The index parameter is the index of the name element to return.
	 *               The element that is closest to the root in the directory
	 *               hierarchy has index 0. The element that is farthest from the
	 *               root has index count-1.
	 * 
	 */
	private static void path_getName_getNameCount(String path) {
		System.out.println("\n--------------\n path_getName_getNameCount\n--------------\n");
		Path p1 = Paths.get(path);
		System.out.println("Pfad : " + p1);

		System.out.println("getNameCount: " + p1.getNameCount());

		for (int i = 0; i < p1.getNameCount(); i++) {
			Path p = p1.getName(i);
			System.out.printf("    getName(%d) = %s", i, p);
		}
		System.out.println();
	}

	/**
	 * EXAM
	 * 
	 * @getFileName Returns the name of the file or directory denoted by this path
	 *              as a Path object. The file name is the farthest element from the
	 *              root in the directory hierarchy.
	 * 
	 */
	private static void pathgetFileName(String path) {
		System.out.println("\n--------------\n pathFileName\n--------------\n");
		Path p1 = Paths.get(path);

		Path fileName = p1.getFileName(); // Geht für Dateien wie auch Verzeichnisse
		System.out.println("getFileName: " + fileName);
	}

	/**
	 * EXAM
	 * 
	 * @getRoot liefert das Root Element des Pfades wenn vorhanden, sonst null;
	 * 
	 *          Returns the root component of this path as a Path object,or null if
	 *          this path does not have a root component.
	 */
	private static void pathGetRoot(String path) {
		System.out.println("\n--------------\n pathGetRoot\n--------------\n");

		Path p01 = Paths.get(path);

		Path root = p01.getRoot();
		System.out.println("getRoot : " + root);
	}

	/**
	 * EXAM
	 */
	private static void pathNormalize() {
		System.out.println("\n--------------\n pathNormalize\n--------------\n");

		Path p01 = Paths.get("a/../c");
		System.out.println("p01 : " + p01);
		/**
		 * @normalize Returns a path that is this path with redundant name elements
		 *            eliminated.
		 */
		Path p02 = p01.normalize();
		System.out.println("p02 : " + p02);

		Path p03 = Paths.get("C:\\Windows\\..\\System32\\..\\temp\\CC245194\\..\\..\\Windows");
		System.out.println("p03 : " + p03);// C:\Windows\..\System32\..\temp\CC245194\..\..\Windows
		System.out.println("p03.normalize() : " + p03.normalize());
		// C:\Windows\..\System32\..\temp\CC245194\..\..\Windows
	}

	private static void pathEquals() {
		System.out.println("\n--------------\n pathEquals\n--------------\n");

		Path p1 = Paths.get("testfiles/subdir");
		Path p2 = Paths.get("testfiles/subdir");

		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);

		System.out.println("1. p1 == p2 : " + (p1 == p2));// false
		System.out.println("2. p1.equals(p2) : " + (p1.equals(p2)));// true
		System.out.println("------------");
		/**
		 * .. bedeuted eine Ebene nach oben
		 */
		// a/b/.. -> a/
		// a/b/../d -> a/d
		p1 = Paths.get("a", "b", "..", "d");
		p2 = Paths.get("a/d");

		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);

		/**
		 * alle Laufinformationen enthalten bleiben.
		 */
		System.out.println("3. p1 == p2 : " + (p1 == p2));// false
		System.out.println("4. p1.equals(p2) : " + (p1.equals(p2)));// false
		System.out.println("------------");
	}

}
