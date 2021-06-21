package ml.mauerbach.funktionale_interfaces.aufgaben.aufgabe_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import static ml.mauerbach.funktionale_interfaces.aufgaben.aufgabe_02.Composition.*;

interface StringProcessor{
	void process(String s);
}
/*
 * Bitte realisieren Sie 'StringProcessor' so, dass die Anwendung die Strings
 * (Zeile 18, 19 und 20) auf der Konsole ausgibt
 * 
 * Realisieren Sie die Aufgaben mit Lambda Ausdrücken und mit
 * Methoden Referenzen. - Probieren Sie auch hier mehrere Notationen aus.
 * 
 * Bonus: Passen Sie die Ausgaben an z.b. alles in LowerCase oder UpperCase.
 */
public class Aufgabe_02_Methodenreferenz {
	static String s1 = "Hallo Welt!";
	static String s2 = "Wir arbeiten mit Methoden Referenzen";
	static String s3 = "Java ist auch eine Insel";
	static String s4 = "  Trimm-mich-Pfad   ";
	static String[] sa = {s1,s2,s3,s4};

	public static void main(String[] args) {
		StringProcessor sp;
		sp = (String s) -> {System.out.println(s);};
		sp = (String s) -> System.out.println(s);
		sp = (s) -> System.out.println(s);
		sp = s -> System.out.println(s);
		sp = System.out::println;
		sp = s -> System.out.println(s.toLowerCase());
		
		Arrays.asList(sa).stream().forEach(sp::process);
		
		

		Consumer<String> sc = c(String::toLowerCase,System.out::println);
		sc.accept("Hallo");
		
		sc = c(o(String::trim, String::toLowerCase),System.out::println);
		sc.accept(" Hallo ");
		
		sc = c(String::length,System.out::println);
		sc.accept("Hallo");
		
		
		List<UnaryOperator<String>> luos = new ArrayList<UnaryOperator<String>>();
		luos.add(String::trim);
		luos.add(String::toLowerCase);
		luos.add(String::toUpperCase);
		
		List<UnaryOperator<String>> luos2 = new ArrayList<>(Arrays.asList(
				String::trim
				,String::toLowerCase
				//,String::toUpperCase
		));
		
		sc = c(o(luos2),System.out::println);
		
		Arrays.asList(sa).stream().forEach(sc::accept);
		
		sc = c(o(o(luos), String::length), System.out::println);
		
		Arrays.asList(sa).stream().forEach(sc::accept);
		
	}
}

class Composition{
	//consume
	public static <T,U> Consumer<T> c(Function<T,U> o,Consumer<U> c){
		return ((T t) -> c.accept(o.apply(t)));
	}
	
	//compose Functions
	public static <T,U,V> Function<T,V> o(Function<T,U> f,Function<U,V> g){
		return ((T t) -> g.apply(f.apply(t)));
	}
	
	//compose UnaryOperators
	public static <T> UnaryOperator<T> oUO(UnaryOperator<T> o,UnaryOperator<T> p){
		return ((T t) -> p.apply(o.apply(t)));
	}
	
	//compose List of UnaryOperators
	public static <T> UnaryOperator<T> o(List<UnaryOperator<T>> l){
		UnaryOperator<T> o = ((T t) -> t);
		for(UnaryOperator<T> p:l) {
			o=oUO(o,p);
		}
		return o;
	}
}
