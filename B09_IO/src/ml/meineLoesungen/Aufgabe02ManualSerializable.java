package ml.meineLoesungen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import io03_serializable.Teilnehmer;

/**
 * Erweitern Sie die Klasse Getriebe:
 * 
 * Erstellen Sie alle n�tigen Methoden, ohne die Klasse Zahnrad anzupassen, um
 * die Klasse Getriebe zu serialisieren.
 * 
 *
 * Bitte einmal Manuell Serialisieren und dann von der Klasse wieder
 * Deserialisieren lassen
 * 
 * @Bonus Die Objekte mit JSON Serialisieren und Deserialisieren.
 *
 */
public class Aufgabe02ManualSerializable {

	/**
	 * Die Klasse Zahnrad darf nicht mit implements java.io.Serializable versehen
	 * werden und soll auch sonst unver�ndert bleiben.
	 *
	 */
	static class Zahnrad {
		int zaehne;
		
		Zahnrad() {
			this(0);
		}
		
		Zahnrad(int zaehne) {
			this.zaehne = zaehne;
		}

		@Override
		public String toString() {
			return "Zahnrad [zaehne=" + zaehne + "]";
		}
	}

	/**
	 * Diese Klasse d�rfen Sie anpassen, so wie es ben�tigt wird.
	 * 
	 * Jedoch nicht die Attribute entfernen.....:)
	 */
	static class Getriebe implements Serializable {
		public transient Zahnrad klein;
		public transient Zahnrad mittel;
		public transient Zahnrad gross;
		
		@Override
		public String toString() {
			return "Getriebe [klein=" + klein + ", mittel=" + mittel + ", gross=" + gross + "]";
		}
	}


	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file = "filesAufgaben\\getriebe01";
		
		Getriebe g01 = new Getriebe();
		g01.klein = new Zahnrad(6);
		g01.mittel = new Zahnrad(9);
		g01.gross = new Zahnrad(12);
		System.out.println(g01);
		
		object2File(file, g01);
		
		Getriebe g02 = file2Object(file);
		System.out.println(g02);

	}

	private static void object2File(String file, Getriebe g01) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.defaultWriteObject();
		oos.writeInt(g01.klein.zaehne);
		oos.writeInt(g01.mittel.zaehne);
		oos.writeInt(g01.gross.zaehne);
		
		System.out.println("Serialisierung erledigt");
		oos.close();
	}
	
	
	private static Getriebe file2Object(String file) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		Object obj = ois.readObject();
		Getriebe g02 = (Getriebe) obj;

		System.out.println("Deserialisieren erledigt");
		ois.close();
		return g02;
	}




}
