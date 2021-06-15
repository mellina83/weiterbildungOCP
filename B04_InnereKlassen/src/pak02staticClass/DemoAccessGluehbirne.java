package pak02staticClass;

import pak02staticClass.Lampe.*;
import static pak02staticClass.Lampe.Gluehbirne.*;

public class DemoAccessGluehbirne {
	public static void main(String[] args) {
		pak02staticClass.Lampe.Gluehbirne birne01 = new pak02staticClass.Lampe.Gluehbirne();
		Lampe.Gluehbirne birne02 = new Lampe.Gluehbirne();
		
		Gluehbirne birne03 = new Lampe.Gluehbirne();
		Lampe.Gluehbirne birne04 = new Gluehbirne();
		Gluehbirne birne05 = new Gluehbirne();
		
		Lampe.Gluehbirne.ausgabeStatic();
		
		System.out.println(Gluehbirne.gluehBirneS);
		System.out.println(gluehBirneS);	
		
//		System.out.println(birne01.getClass());
//		System.out.println(birne02.getClass());
//		System.out.println(birne03.getClass());
//		System.out.println(birne04.getClass());
//		System.out.println(birne05.getClass());
	}
}
