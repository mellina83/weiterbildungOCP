package nio;

import java.io.IOException;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

public class Demo03Files_API {

	public static void main(String[] args) {
		/**
		 * Abfragen ob eine Datei und oder ein Verzeichnis existiert
		 */
//		files_exists();

		/**
		 * Zum Kopieren von Dateien
		 */
//		files_copy();

		/**
		 * Zum Verschieben von Dateien und Verzeichnisse
		 */
//		files_move();
//		files_move_dir();
		
		/**
		 * Zum L�schen von Dateien und Verzeichnissen
		 */
//		files_delete();
		
		/**
		 * Lesen von Datei Attributen
		 */
//		files_readAttributes();
//		files_read_Dos_Attributes();
		
		/**
		 * Abk�rzungen zu den Attributen
		 */
//		files_shortcuts_readAttributes();
	}

	private static void files_shortcuts_readAttributes() {
		System.out.println("\n--------------\n files_shortcuts_readAttributes\n--------------\n");

		Path path = Paths.get("testfiles/lorem.txt");
		System.out.println("path: " + path);
		
		System.out.println("isDirectory : " + Files.isDirectory(path));
		System.out.println("isRegularFile : " + Files.isRegularFile(path));
		System.out.println("isWritable : " + Files.isWritable(path));
		System.out.println("schauen Sie in die API der Klasse java.nio.file.Files");
		
	}

	private static void files_read_Dos_Attributes() {
		Path path = Paths.get("testfiles/lorem.txt");
		System.out.println("path: " + path);
		
		try {
			DosFileAttributes attributes = Files.readAttributes(path, DosFileAttributes.class);
			
			System.out.println("attributes.isArchive() : " + attributes.isArchive());
			System.out.println("attributes.isHidden() : " + attributes.isHidden());
			System.out.println("attributes.isReadOnly() : " + attributes.isReadOnly());
			System.out.println("attributes.isSystem() : " + attributes.isSystem());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * public static <A extends BasicFileAttributes> A readAttributes(Path path,
	 * Class<A> type, LinkOption... options)
	 */
	private static void files_readAttributes() {
		System.out.println("\n--------------\n files_readAttributes\n--------------\n");
		
		Class<BasicFileAttributes> type = BasicFileAttributes.class;
		
		Path path = Paths.get("testfiles/lorem.txt");
		System.out.println("path : " + path);
		
		try {
			BasicFileAttributes attributes = Files.readAttributes(path, type);
			
			System.out.println("boolean isRegularFile() : " + attributes.isRegularFile());
			System.out.println("boolean isDirectory : " + attributes.isDirectory());
			System.out.println("size (bytes, long): " + attributes.size());
			
			FileTime creationTime = attributes.creationTime();
			System.out.println("creationTime : " + creationTime);
			
			/**
			 * Plattform Spezifisch
			 */
			FileTime lastModifiedTime = attributes.lastModifiedTime();
			System.out.println("lastModifiedTime : " + lastModifiedTime);
			
			FileTime lastAccessTime = attributes.lastAccessTime();
			System.out.println("lastAccessTime : " + lastAccessTime);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void files_delete() {
		System.out.println("\n--------------\n files_delete\n--------------\n");
		
//		Path path = Paths.get("does", "not", "exist");
//		Path path = Paths.get("testfiles");
		Path path = Paths.get("testfiles/lorem2.txt");
		
		try {
			/**
			 * If the 'Path' is a directory then the directory must be empty.
			 * 
			 * DirectoryNotEmptyException - if the file is a directory and could not
			 * otherwise be deleted because the directory is not empty
			 */
			
//			Files.delete(path);
			System.out.println("Loeschen erfolgreich : " + Files.deleteIfExists(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void files_move_dir() {
		System.out.println("\n--------------\n files_move_dir\n--------------\n");

		Path source = Paths.get("testfiles"); // Das Verzeichnis ist nicht leer
		Path target = Paths.get("D:/lorem/testfiles");

		System.out.println("target: " + target);
		System.out.println(" gefunden VOR: " + Files.exists(target));
		
//		try {
//			Files.move(source, target);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("target: " + target);
		System.out.println(" gefunden NACH: " + Files.exists(target));
	}

	private static void files_move() {
		System.out.println("\n--------------\n files_move\n--------------\n");

		Path source = Paths.get("testfiles/zitat.csv");
		Path target = Paths.get("lorem/zitat.csv");

		System.out.println("target: " + target);
		System.out.println(" gefunden VOR: " + Files.exists(target));

		try {
			Files.move(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("target: " + target);
		System.out.println(" gefunden NACH: " + Files.exists(target));
	}

	private static void files_copy() {
		System.out.println("\n--------------\n files_copy\n--------------\n");

		Path sourceFile = Paths.get("testfiles/lorem.txt");
		System.out.println("sourceFile: " + sourceFile);
		System.out.println("  gefunden: " + Files.exists(sourceFile));

		/**
		 * Achtung, Angabe der Ziel-DATEI nicht nur des Ziel-Verzeichnisses
		 */
//		Path targetFile = Paths.get("lorem/subdir");//FALSCH
		Path targetFile = Paths.get("lorem/subdir/lorem_copy.txt");

		System.out.println("targetFile: " + targetFile);
		System.out.println("  gefunden VOR: " + Files.exists(targetFile));

		try {
//			Files.copy(sourceFile, targetFile);
			Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("  gefunden Nach Copy: " + Files.exists(targetFile));
	}

	/**
	 * EXAM
	 * 
	 * @exists Tests whether a file or directory exists.
	 * 
	 *         public static boolean exists(Path path, LinkOption... options)
	 *
	 *         'path' the path to the file to test
	 * 
	 *         'options' options indicating how symbolic links are handled
	 *
	 *         The options parameter may be used to indicate how symbolic links are
	 *         handled for the case that the file is a symbolic link.
	 * 
	 *         By default, symbolic links are followed.
	 * 
	 *         If the option LinkOption.NOFOLLOW_LINKS is present then symbolic
	 *         links are not followed.
	 */
	private static void files_exists() {
		System.out.println("\n--------------\n files_exists\n--------------\n");
		Path path = Paths.get("D:\\test\\geheim\\Mein Password.txt");

		boolean gefunden = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		System.out.println("1. path " + path);
		System.out.println("gefunden: " + gefunden);

		path = Paths.get("src", "nio", "Demo03Files_API.java");

		gefunden = Files.exists(path);
		System.out.println("2. path " + path);
		System.out.println("gefunden: " + gefunden);
	}

}
