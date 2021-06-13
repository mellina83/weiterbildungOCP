package ml.Musfeldt.a06_09;

import java.util.Scanner;

public class Enum_KaffeeAutomat{
	
	public enum KaffeeSorten{
		KAFFEE{
			final double preis = 1.00;
			@Override
			public double getPreis() {
				return preis;
			}
		}
		,CAPPUCCINO{
			final double preis = 1.20;
			@Override
			public double getPreis() {
				return preis;
			}
		}
		,ESPRESSO{
			final double preis = 1.13;
			@Override
			public double getPreis() {
				return preis;
			}
		};
		
		double preis;
		public double getPreis() {
			return preis;
		}
		}
	
	//********************************************************************************************************
	
		public static void preisausgabe(KaffeeSorten a) {
			System.out.println("Ein " + a.name() + " kostet: " + a.getPreis() + "€");
		}
		
		public static void preisausgabeGesammt() {
			for (KaffeeSorten kaffeesorte : KaffeeSorten.values()) {
				preisausgabe(kaffeesorte);
			}
		}
		public static void auswaertung(String auswahl) {
			switch(auswahl){
				case "1":
					System.out.println("Werfen Sie " + KaffeeSorten.KAFFEE.getPreis() + " € ein.");
					break;
				case "2":
					System.out.println("Werfen Sie " + KaffeeSorten.CAPPUCCINO.getPreis() + " € ein.");
					break;
				case "3":
					System.out.println("Werfen Sie " + KaffeeSorten.ESPRESSO.getPreis() + " € ein.");
					break;
				case "Kaffee":
					System.out.println("Werfen Sie " + KaffeeSorten.KAFFEE.getPreis() + " € ein.");
					break;
				case "Cappuccino":
					System.out.println("Werfen Sie " + KaffeeSorten.CAPPUCCINO.getPreis() + " € ein.");
					break;
				case "Espresso":
					System.out.println("Werfen Sie " + KaffeeSorten.ESPRESSO.getPreis() + " € ein.");
					break;
				default:
					System.out.println("Ungültig");
					break;
			}
		}
		
	//********************************************************************************************************
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Willkommen. Was wollen Sie kaufen?");
		preisausgabeGesammt();
//		System.out.println("Drücken sie die entsprechende Taste für ihre Wahl.");
//		System.out.println("1. Kaffee");
//		System.out.println("2. Cappuccino");
//		System.out.println("3. Espresso");
		auswaertung(sc.nextLine());
//		System.out.println("Sie haben " + auswahl + " gewählt.");
		
		//preisausgabe(KaffeeSorten.CAPPUCCINO);
	}
}
