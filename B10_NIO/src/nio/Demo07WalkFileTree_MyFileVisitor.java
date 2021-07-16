package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo07WalkFileTree_MyFileVisitor {

	public static void main(String[] args) {
		Path start = Paths.get(".");
		Path target = Paths.get("D:/testnio");

		MyFileVisitor<Path> visitor = new MyFileVisitor<Path>(".txt", target);
		
		try {
			Files.walkFileTree(start, visitor);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
