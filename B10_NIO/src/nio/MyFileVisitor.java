package nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class MyFileVisitor<T extends Path> extends SimpleFileVisitor<T>{

	private String filter;
	private Path target;
	
	/**
	 * 
	 * @param filter 
	 * @param target Ziel Verzeichnis für die gefundenen Dateien
	 */
	public MyFileVisitor(String filter,Path target) {
		this.filter = filter;
		this.target = target;
	}
	
	@Override
	public FileVisitResult visitFile(T file, BasicFileAttributes attrs) throws IOException {
		
		if(file.toString().toLowerCase().endsWith(filter)) {
			Files.copy(file, target.resolve(file.getFileName()));
		}
		return FileVisitResult.CONTINUE;
	}
	
}
