package nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Anforderung In einem Verzeichnis alle ".txt" Dateien finden. Inklusive Unterverzeichnisse 
 *
 */
public class Demo05_DateienFinden {

	static List<File> foundFiles = new ArrayList<>();
	
	public static void main(String[] args) {
		Path p01 = Paths.get(".");

		findFile(p01.toFile(), ".java");
		System.out.println(foundFiles);
		System.out.println(foundFiles.size());
	}

	private static void findFile(File start, String toFind) {
		File[] allFiles = start.listFiles();	
		for (File file : allFiles) {
			if(file.isDirectory()) {
				findFile(file, toFind);
			} else {
				if(file.toString().toLowerCase().endsWith(toFind)) {
					foundFiles.add(file);
				}
			}
		}
	}
}
