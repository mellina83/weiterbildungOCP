package demo01;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteToFile {

	public static void main(String[] args) throws Exception{
		Buch buch01 = new Buch();
		buch01.setTitel("Jackson Tutorial");
		buch01.setIsbn("1233-123-123");
		buch01.addAutor(new Autor("Dürbeck","Melanie"));
		buch01.addAutor(new Autor("Schirmer","Christian"));
		
		System.out.println(buch01);
		
		/**
		 * Mit dem Jackson-Framework zu json
		 */
		File file = new File("./save/" + buch01.getIsbn() +".json");
		ObjectMapper mapper = new ObjectMapper();
		
		/**
		 * Aus Buch wird nun ein JSON-String
		 */
		String json = mapper.writeValueAsString(buch01);
		mapper.writeValue(file, buch01);
		System.out.println(json);
		System.out.println("Beendet");
	}

}
