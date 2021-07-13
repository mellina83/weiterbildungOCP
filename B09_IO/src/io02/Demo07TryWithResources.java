package io02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo07TryWithResources {

	static class Zitat {
		private String text;
		private String verfasser;

		public Zitat() {

		}

		public Zitat(String csvText) {
			Objects.requireNonNull(csvText);

			if (csvText.contains(";")) {
				String[] splitted = csvText.split(";");
				text = splitted[0];
				verfasser = splitted[1];
			}
		}

		@Override
		public String toString() {
			return "Zitat: " + text + "\n\t\t" + verfasser;
		}
	}
	
	public static void main(String[] args) {
		List<Zitat> list = new ArrayList<>();

		InputStream is;//Byte Daten einlesen
		Reader in;//Textdateien
		
		try(FileReader fr = new FileReader("./testfiles/zitat.csv");
				BufferedReader br = new BufferedReader(fr);){
			
//			while(br.ready()) {
//				list.add(new Zitat(br.readLine()));
//			}
			
//		     Stream<String> -> map -> Stream<Zitat>
			list = br.lines().map(Zitat::new).collect(Collectors.toList());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
	}

}
