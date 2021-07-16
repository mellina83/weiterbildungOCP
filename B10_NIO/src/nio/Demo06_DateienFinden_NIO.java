package nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 
 * public static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path,
 * BasicFileAttributes> matcher, FileVisitOption... options)
 * 
 * Return a Stream that is lazily populated with Path by searching for files in
 * a file tree rooted at a given starting file.
 * 
 * Parameters:
 * 
 * start the starting file
 * 
 * maxDepth the maximum number of directory levels to search
 * 
 * matcher the function used to decide whether a file should be included in the
 * returned stream
 * 
 * options options to configure the traversal
 */
public class Demo06_DateienFinden_NIO {

	public static void main(String[] args) throws Exception {
//		Path start = Paths.get(".");
		Path start = Paths.get("c:/Windows");
		int maxDepth = 1024;
		String searchFor = ".java";
		
		
		BiPredicate<Path, BasicFileAttributes> matcher = (path, attr) -> {
			if(path.getFileName().toString().toLowerCase().endsWith(searchFor)) {
				return true;
			}
			return false;
		};

		Stream<Path> found = Files.find(start, maxDepth, matcher);
		System.out.println(found.collect(Collectors.toList()));
	}

}
