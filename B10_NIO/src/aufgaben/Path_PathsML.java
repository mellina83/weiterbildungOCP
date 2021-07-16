package aufgaben;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Nutzen Sie Path und Paths.
 * 
 * Geben Sie das Root Element ihres Workspace aus.
 * 
 * Geben Sie den Absoluten Pfad ihres Workspace aus.
 * 
 * Zählen Sie die 'Namen' aus dem Absoluten Pfad ihres Workspace.
 * 
 * Geben Sie die 'Verzeichnisnamen' zu einem Beliebiegen Projekt aus ihrem
 * Workspace nacheinander aus.
 * 
 */
public class Path_PathsML {

	public static void main(String[] args) {
		System.out.println("Root Element : " + Paths.get(".").toAbsolutePath().getRoot());

		/**
		 * Geben Sie den Absoluten Pfad ihres Workspace aus.
		 */
		Path workspace = Paths.get("./..").toAbsolutePath().normalize();
		System.out.println("Workspace : " + workspace);

		/**
		 * Zählen Sie die 'Namen' aus dem Absoluten Pfad ihres Workspace.
		 */
		System.out.println("Anzahl der Namen im Workspace : " + workspace.getNameCount());

		/**
		 * Geben Sie die 'Verzeichnisnamen' zu einem Beliebiegen Projekt aus ihrem
		 * Workspace nacheinander aus.
		 */
		Path projekt = Paths.get(".").toAbsolutePath();
		int count = projekt.getNameCount();
		for(int i=0;i<count;i++) {
			System.out.println(projekt.getName(i));
		}
	}

}
