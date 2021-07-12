package io01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Properties;

public class Demo02File {

	public static void main(String[] args) {
		demoFiles();

//		readSystemProperties();
	}

	private static void readSystemProperties() {
		Properties prop = System.getProperties();
		prop.list(System.out);
	}

	private static void demoFiles() {
		String fs = System.getProperty("file.separator");//
		
		File path01 = new File("123");
		File path02 = new File("testfiles" + fs + "subdir01" + fs);
		File path03 = new File("testfiles" + fs + "subdir01" + fs + "LiesMich.txt");
		
		System.out.println("path01-------");
		printFileInfos(path01);
		System.out.println("\n\npath02-------");
		printFileInfos(path02);
		System.out.println("\n\npath03-------");
		printFileInfos(path03);
		
		/*
		 * Aktuelles Arbeitsverzeichnis
		 */
		System.out.println("\n\nAktuelles Arbeitsverzeichnis-------");
		File dir = new File(".");
		printFileInfos(dir);
		
		FileFilter directoryFilter = File::isDirectory;
		
		File[] allFiles =dir.listFiles(directoryFilter);
		for(File file : allFiles) {
			System.out.println(file);
		}
		
		System.out.println("\n\nMit Stream");
		Arrays.stream(dir.listFiles()).forEach(System.out::println);
		
		/**
		 * In der 2. Ausgabe möchte ich nur noch die Dateien ausgegeben bekommen.
		 */
		System.out.println("Filter mit Stream");
		Arrays.stream(dir.listFiles(File::isFile)).forEach(System.out::println);
		System.out.println("------------");
		Arrays.stream(dir.listFiles()).filter(File::isFile).forEach(System.out::println);
	}

	private static void printFileInfos(File path) {
		System.out.println("\nFile Info : " + path);
		System.out.println("--> path.toString : " + path.toString());
		System.out.println("exits() : " + path.exists());
		System.out.println("isDirectory() : " + path.isDirectory());
		System.out.println("isFile() : " + path.isFile());
		String abs01 = path.getAbsolutePath();
		System.out.println("getAbsolutePath() : " + abs01);
		File abs02 = path.getAbsoluteFile();
		System.out.println("getAbsoluteFile() : " + abs02);
	}

}
