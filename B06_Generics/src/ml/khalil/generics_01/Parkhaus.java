package ml.khalil.generics_01;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus< Fahrzeug> {
	

	List<Fahrzeug> parkhaus_list;
	public Parkhaus()
	{parkhaus_list=new ArrayList<>();}

	void add(Fahrzeug f) {
		parkhaus_list.add(f);
	}
	
	void print() {
		parkhaus_list.stream().forEach(System.out::println);
	}
	
}
