package demo01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo01Jackson {

	public static void main(String[] args) throws Exception{
		List<Integer> list = new Random().ints(500, 0, 500).boxed().collect(Collectors.toList());

		
		ObjectMapper mapper = new ObjectMapper();
		
		//mapper.writeValue(new File("./save/zahlen"), list);
		
		List<Integer> list02 = mapper.readValue(new File("./save/zahlen"), List.class);
		System.out.println(list02);
	}

}
