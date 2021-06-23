package ml.khalil.generics_01;

public class App {

	public static void main(String[] args) {
		LKW lkw1=new LKW(true,1);
		LKW lkw2=new LKW(false,2);
		LKW lkw3=new LKW(true,3);
		
		PKW pkw1=new  PKW(true,4);
		PKW pkw2=new  PKW(false,5);
		PKW pkw3=new  PKW(true,6);
		Parkhaus< Fahrzeug> p=new Parkhaus<>();
		Waschstrasse<LKW> waschstrasse_LKW =new Waschstrasse<>(p);
		Waschstrasse<PKW> waschstrasse_PKW =new Waschstrasse<>(p);
		
		waschstrasse_LKW.add(lkw1);
		waschstrasse_LKW.add(lkw2);
		waschstrasse_LKW.add(lkw3);
		
		waschstrasse_LKW.waschen();
		
		waschstrasse_PKW.add(pkw1);
		waschstrasse_PKW.add(pkw2);
		waschstrasse_PKW.add(pkw3);
		
		waschstrasse_PKW.waschen();
		
		p.print();
		
		

	}

}
