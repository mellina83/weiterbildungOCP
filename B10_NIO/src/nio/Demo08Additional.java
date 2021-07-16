package nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class Demo08Additional {

	static Path start = Paths.get("c:/Java");
//	static Path start = Paths.get("c:/Windows");

	public static void main(String[] args) throws Exception {
//		files_list();

//		files_walk();

//		files_newDirectoryStream();

		files_walkFileTree();
	}

	private static void files_walkFileTree() throws IOException {
		System.out.println("*** walkFileTree. Geht AUCH in die Unterverzichnisse");

		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				System.out.println(dir);
				if(dir.endsWith("MeinRRechner")) {
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
		};
		
		Path mypath = Files.walkFileTree(start, visitor);
		System.out.println("mypath : " + mypath);
	}

	private static void files_newDirectoryStream() {
		System.out.println("*** newDirectoryStream. Geht NICHT in die Unterverzeichnisse");

		DirectoryStream.Filter<Path> filter = (path) -> {
			return path.getFileName().toString().endsWith(".pdf");
		};

//		try(DirectoryStream<Path> dirIterable = Files.newDirectoryStream(start)){
//		try(DirectoryStream<Path> dirIterable = Files.newDirectoryStream(start,"*.txt")){	
		try (DirectoryStream<Path> dirIterable = Files.newDirectoryStream(start, filter)) {

//			for(Path dir : dirIterable) {
//				System.out.println(dir);
//			}

			dirIterable.forEach(System.out::println);

		} catch (IOException e) {

		}
	}

	private static void files_walk() throws IOException {
		System.out.println("*** walk. Geht AUCH in die Unterverzichnisse");

		/**
		 * Stream<Path> walk(Path start, FileVisitOption... options)
		 * 
		 * Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options)
		 * 
		 */
		// Files.walk(start).forEach(System.out::println);

		Files.walk(start, 2).forEach(System.out::println);
	}

	private static void files_list() throws Exception {
		System.out.println("*** list. Geht NICHT in die Unterverzeichnisse");

		/**
		 * Stream<Path> list(Path start)
		 */
		Files.list(start).forEach(System.out::println);
	}

}
