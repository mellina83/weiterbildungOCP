package nio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * Den FileVisitor benötigen wir, wenn wir einen Verzeichnisbaum durchlaufen
 * wollen.
 * 
 * Das bedeutet, alle Dateien und Verzeichnisses innerhalb eines Baumes
 * durchzugehen.
 * 
 * Es kommen dabei 4 Methoden aus dem FileVisitor Interface zum einsatz.
 * 
 * @preVisitDirectory Invoked before a directory's entries are visited.
 * 
 * @postVisitDirectory Invoked after all the entries in a directory are visited.
 *                     If any errors are encountered, the specific exception is
 *                     passed to the method.
 * 
 * @visitFile Invoked on the file being visited. The file's BasicFileAttributes
 *            is passed to the method, or you can use the file attributes
 *            package to read a specific set of attributes. For example, you can
 *            choose to read the file's DosFileAttributeView to determine if the
 *            file has the "hidden" bit set.
 * 
 * @visitFileFailed Invoked when the file cannot be accessed. The specific
 *                  exception is passed to the method. You can choose whether to
 *                  throw the exception, print it to the console or a log file,
 *                  and so on.
 * 
 * 
 * @more https://docs.oracle.com/javase/tutorial/essential/io/walk.html
 *
 */

public class Demo06WalkFiletree {

	
	static Path start = Paths.get("c:/Windows");
	//static Path start = Paths.get("../");
	
	public static void main(String[] args) {
		FileVisitor<Path> simpleVisitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(file.toString().endsWith(".dll")) {
					//System.out.println(file);
				}
				
				if(file.toString().toLowerCase().endsWith(".wim")) {
					System.out.println(file);
					return FileVisitResult.TERMINATE;
				}
				
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				System.err.println("Zugriff Verweigert auf : " + file);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				
				if(dir.toString().toLowerCase().contains("winsxs")) {
					return FileVisitResult.SKIP_SUBTREE;
				}
				//System.out.println("Betrete Verzeichnis : " + dir);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				
				//System.out.println("Verlasse Verzeichnis : " + dir);
				return FileVisitResult.CONTINUE;
			}
		};

		try {
			Files.walkFileTree(start, simpleVisitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
