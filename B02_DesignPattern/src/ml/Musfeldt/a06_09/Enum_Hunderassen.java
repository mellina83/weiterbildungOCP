package ml.Musfeldt.a06_09;

public class Enum_Hunderassen {

	public enum Hunderassen{
		DACKEL{
			private final double maxGroesse = 0.5;
			private final String beschreibung = "Dackel, max. Groesse: " + maxGroesse;
			@Override
			public String ausgabe() {
				return beschreibung;
			}
		}
		,COLLIE{
			private final double maxGroesse = 1.0;
			private final String beschreibung = "Collie, max. Groesse: " + maxGroesse;
			@Override
			public String ausgabe() {
				return beschreibung;
			}
		}
		,DOGGE{
			private final double maxGroesse = 1.5;
			private final String beschreibung = "Dogge, max. Groesse: " + maxGroesse;
			@Override
			public String ausgabe() {
				return beschreibung;
			}
		};
		
		public abstract String ausgabe();
		
	}
	
	public static void main(String[] args) {
		
		for (Hunderassen hunderassen : Hunderassen.values()) {
			System.out.println(hunderassen.ausgabe());
		}

	}

}
