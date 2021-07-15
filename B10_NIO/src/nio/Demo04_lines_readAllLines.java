package nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo04_lines_readAllLines {

	static Path textFile = Paths.get("lorem/lorem.txt");

	static {
		try (PrintWriter out = new PrintWriter(textFile.toFile())) {
			for (int i = 0; i < 3; i++) {
				out.println("Lorem ipsum dolor sit amet");
				out.println("consetetur sadipscing elitr");
				out.println("sed diam nonumy");
				out.println("eirmod tempor invidunt ut labore");
				out.println("et dolore magna aliquyam");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("\n--------------\n Files.readAllLines()\n--------------\n");

		List<String> lines = Files.readAllLines(textFile);
		// lines.forEach(System.out::println);

//		Files.lines(textFile).filter(str -> str.contains("Lorem")).forEach(System.out::println);

//		Files.lines(Paths.get("testfiles/RandomArray.txt")).map(str -> Integer.parseInt(str))
//				.forEach(System.out::println);

		Files.write(Paths.get("lorem/WritenWithFiles.txt"), lines);
	}

}
