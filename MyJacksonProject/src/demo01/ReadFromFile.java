package demo01;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFromFile {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Lesen");
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File("./save/" + "1233-123-123" +".json");
		Buch buch01 = mapper.readValue(file, Buch.class);

		System.out.println(buch01);
		System.out.println("Beendet");
	}

}
