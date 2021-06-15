package pak02staticClass;

//import static pak02staticClass.Lampe.Gluehbirne.*;

public class Lampe {
	
	public static String s = "Licht AN";
	private int i = 1;
	
	public static class Gluehbirne{
		public static String gluehBirneS = "Dunkel";
		public int gluehBirneI = 6;
		
		public static void ausgabeStatic() {
			System.out.println("Statics");
			System.out.println(s);
			System.out.println(gluehBirneS);
			//Cannot make a static reference to the non-static field gluehBirneI
//			System.out.println(gluehBirneI);
		}
		public void ausgabe() {
			System.out.println("Nonstatic");
			System.out.println(s);
			System.out.println(gluehBirneS);
			System.out.println(gluehBirneI);
			
			/*
			 * Auf das Instanzattribut i von Lampe haben wir hier keinen Zugriff
			 * da von Lampe kein Objekt existiert 
			 */
			//Cannot make a static reference to the non-static field i
//			System.out.println(i);
			System.out.println(new Lampe().i);
		}
		
		
	}
	
	public static void main(String[] args) {
		Lampe.Gluehbirne 	birne01 = new Lampe.Gluehbirne();
		Gluehbirne 			birne02 = new Lampe.Gluehbirne();
		Lampe.Gluehbirne	birne03 = new Gluehbirne();
		Gluehbirne 			birne04 = new Gluehbirne();
		
		System.out.println(birne01.getClass());
		System.out.println(birne02.getClass());
		System.out.println(birne03.getClass());
		System.out.println(birne04.getClass());
		
		Lampe.Gluehbirne.ausgabeStatic();
		Gluehbirne.ausgabeStatic();
		//nur mit statischem import der Inhalte von Gluehbirne
//		ausgabeStatic();
		
	}
	
}
