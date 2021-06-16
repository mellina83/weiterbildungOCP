package ml.Duerbeck.basics;

public class LokaleKlassen {

	public static void main(String[] args) {

	}
	
	class SpassInnerhalb {
			
		public void testen() {
			
			int i = 2;
			final int j = 3;
//			i = 4; <--- zerstoert das effectively final
			
			class Innerhalb {
				Innerhalb() {
					System.out.println(j); // <--- muss final
					System.out.println(i); // <--- oder effectively final sein
					//Effectively final bedeutet fuer mich, darf nicht geaendert sein nach der Initialisierung
				}
			}
			
			new Innerhalb();
			
			
		}
		
	}

}
