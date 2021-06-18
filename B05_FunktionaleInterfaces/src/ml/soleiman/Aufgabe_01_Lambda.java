package ml.soleiman;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Aufgabe_01_Lambda {

	public static void main(String[] args) {

		String[] arr = { "achtzehnbuchstaben", "dry", "vier", "1", "fuenf", "neunzehn Buchstaben", };

		List<String> woerter = Arrays.asList(arr);
//--------------------------------------------------------------------------------------------
		Comparator<String> nachDerLaengeSortierenAufsteigend1 = comparing(  s -> s.length() );
		Comparator<String> nachDerLaengeSortierenAufsteigend2 = comparing( (s)-> s.length() );
		Comparator<String> nachDerLaengeSortierenAufsteigend3 = comparing( (String s) -> s.length() );
		Comparator<String> nachDerLaengeSortierenAufsteigend4 = comparing( (String s) -> {return s.length();} );
		Comparator<String> nachDerLaengeSortierenAufsteigend5 = comparing(String::length);
		System.out.println("--------------------------------------------");
		Function<String, Integer> f = String::length;
		System.out.println(f.apply("Hallo"));
		
		
		woerter.sort(nachDerLaengeSortierenAufsteigend1);
//--------------------------------------------------------------------------------------------		
		
		//static import
		woerter.sort( comparing(  s -> s.length()) );
		woerter.sort( comparing( (s)-> s.length()) );
		woerter.sort( comparing( (String s) -> s.length()) );
		woerter.sort( comparing( (String s) -> {return s.length();}) );
		woerter.sort( comparing(String::length));

		System.out.println(woerter);
	}
}
