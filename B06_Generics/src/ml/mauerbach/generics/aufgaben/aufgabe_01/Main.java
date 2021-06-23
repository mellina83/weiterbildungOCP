package ml.mauerbach.generics.aufgaben.aufgabe_01;

public class Main {
	public static void main(String[] args) {
		Parkhaus parkhaus = new Parkhaus();
		Waschstrasse<PKW> PKW_Waschstrasse = new Waschstrasse<>(parkhaus);
		Waschstrasse<LKW> LKW_Waschstrasse = new Waschstrasse<>(parkhaus);
		PKW p1 = new PKW();
		PKW p2 = new PKW();
		PKW p3 = new PKW();
		PKW p4 = new PKW();
		
		LKW l1 = new LKW();
		LKW l2 = new LKW();
		LKW l3 = new LKW();
		LKW l4 = new LKW();
		
		p1.setDreckig(true);
		PKW_Waschstrasse.waschen(p1);
		System.out.println(p1);
		
		PKW_Waschstrasse.einfahren(p1);
		p2.setDreckig(true);
		PKW_Waschstrasse.einfahren(p2);
		
		l1.setDreckig(true);
		LKW_Waschstrasse.einfahren(l1);
		LKW_Waschstrasse.einfahren(l2);
		
		System.out.println(parkhaus);
		System.out.println(PKW_Waschstrasse);
		System.out.println(LKW_Waschstrasse);
		
		PKW_Waschstrasse.waschen();
		LKW_Waschstrasse.waschen();
		PKW_Waschstrasse.waschen();
		LKW_Waschstrasse.waschen();
		
		System.out.println(parkhaus);
		System.out.println(PKW_Waschstrasse);
		System.out.println(LKW_Waschstrasse);
		
		PKW_Waschstrasse.waschen();
		LKW_Waschstrasse.waschen();
		PKW_Waschstrasse.waschen();
		LKW_Waschstrasse.waschen();
		
		System.out.println(parkhaus);
		System.out.println(PKW_Waschstrasse);
		System.out.println(LKW_Waschstrasse);
		
	}
}
