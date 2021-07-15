package aufgaben.meineLoesungen;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Nutzen Sie Path und Paths.
 * 
 * Geben Sie das Root Element ihres Workspace aus.
 * 
 * Geben Sie den Absoluten Pfad ihres Workspace aus.
 * 
 * Z�hlen Sie die 'Namen' aus dem Absoluten Pfad ihres Workspace.
 * 
 * Geben Sie die 'Verzeichnisnamen' zu einem Beliebiegen Projekt aus ihrem Workspace
 * nacheinander aus.
 * 
 */
public class Path_Paths {

	public static void main(String[] args) {
		
		Path workspaceAbsolutePath = Paths.get(".").toAbsolutePath();
		System.out.println("Absoluter Pfad: " + workspaceAbsolutePath);
		Path workspaceRoot = workspaceAbsolutePath.getRoot();
		System.out.println("Root Verzeichnis: " + workspaceRoot);
		
		int anzahlNamenElemente = workspaceAbsolutePath.getNameCount();
		System.out.println("Anzahl Namen-Elemente in meinem Workspace-Pfad: " + anzahlNamenElemente);
		
		
		Path workspace = Paths.get("C:\\Users\\CC-Student\\git\\weiterbildung_JavaOCP\\B09_IO\\");
		Path verzeichnisname1 = workspace.getFileName();
		System.out.println("Verzeichnisname: " + verzeichnisname1);
		
	}

}
