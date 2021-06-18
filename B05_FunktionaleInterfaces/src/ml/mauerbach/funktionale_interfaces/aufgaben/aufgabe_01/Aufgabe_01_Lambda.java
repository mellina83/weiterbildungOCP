package ml.mauerbach.funktionale_interfaces.aufgaben.aufgabe_01;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Realisieren Sie bitte einen String-Comparator, der die Strings
 * aus dem Array nach ihren Längen vergleicht und sortiert:
 * 
 * 1. mit einer anonymen Klasse
 * 2. mit Lambda-Funktionen (bitte alle Notationen ausprobieren, die kompilieren)
 * 
 * 
 * Hinweis: Verwenden Sie bitte das Interface Comparator
 */

public class Aufgabe_01_Lambda {
	public static void main(String[] args) {
		String[] arr = { "achtzehnbuchstaben", "dry", "vier", "1", "fuenf",
				"neunzehn Buchstaben", };
		System.out.println(Arrays.toString(arr));
	
		Comparator<String> c;

		c = new Comparator<String>() {
			@Override
			public int compare(String s, String t) {
				return Integer.compare(s.length(),t.length());
			}
		};
		
		c = (s,t) -> Integer.compare(s.length(), t.length());
		
		c = (String s,String t) -> Integer.compare(s.length(),t.length());
		
		c = (s,t) -> {return Integer.compare(s.length(),t.length());};
		
		c = (s,t) -> Aufgabe_01_Lambda.stringLengthComparator(s, t);
		
		c = Aufgabe_01_Lambda::stringLengthComparator;
		
		class C{
			int c(String s,String t) {return Integer.compare(s.length(),t.length());}
		}
		
		c = (s,t) -> new C().c(s,t);
		
		c = (new C())::c;
		
		c = (s,t) -> D.c(s, t);
		
		c = D::c;
		
		c = (s,t) -> (new I(){}).c(s, t);
		
		c = (new I(){})::c;
		
		c = (s,t) -> (
				new J(){
					public int c(String s,String t){
						return Integer.compare(s.length(),t.length());
					}
				}
			).c(s, t);
		
		c = (
				new J(){
					public int c(String s,String t){
						return Integer.compare(s.length(),t.length());
					}
				}
			)::c;
		
		
		Arrays.sort(arr,c);
		
		System.out.println(Arrays.toString(arr));		
	}
	
	public static int stringLengthComparator(String s, String t) {
		return Integer.compare(s.length(),t.length());
	}
	
	static class D{
		static int c(String s,String t) {return Integer.compare(s.length(),t.length());}
	}
	
	static interface I{
		default int c(String s,String t) {return Integer.compare(s.length(), t.length());}
	}
	
	static interface J{
		int c(String s, String t);
	}
}
