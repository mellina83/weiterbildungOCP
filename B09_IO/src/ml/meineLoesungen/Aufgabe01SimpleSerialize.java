package ml.meineLoesungen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Erzeugen Sie eine innere Klasse Tier. Geben Sie der Klasse Tier 2 Primitive
 * Attribute.
 * 
 * Serialisieren Sie 2 Instanzen der Klasse Tier in jeweils eine eigene Datei.
 * beispielsweise 'serializable/tier01' - serializable/tier02'
 * 
 * Nach dem Serialisieren, deserialisieren Sie die dateien wieder und lassen
 * sich die Instanzen anzeigen
 * 
 * Teilen Sie ihre Arbeiten in Methoden auf.
 *
 */


public class Aufgabe01SimpleSerialize {
	
	static class Tier implements Serializable {
		
		private int alter;
		private String name; // String ist serializierbar!
		
		Tier() {
			this(0, "");
		}
		
		Tier(int alter, String name) {
			setAlter(alter);
			setName(name);
		}
		
		
		
		@Override
		public String toString() {
			return "Tier [alter=" + alter + ", name=" + name + "]";
		}

		public int getAlter() {
			return alter;
		}

		public void setAlter(int alter) {
			this.alter = alter;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Tier tier1 = new Tier(12, "Cheetah");
		Tier tier2 = new Tier(33, "Geoffrey");
		
		String file1 = "filesAufgaben\\tier01";
		String file2 = "filesAufgaben\\tier02";
		
		serialisieren(file1, tier1);
		serialisieren(file2, tier2);
		deSerialisieren(file1);
		deSerialisieren(file2);
	}
	
	private static void serialisieren(String file, Serializable obj) throws IOException {
		
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
	
		oos.writeObject(obj);
		System.out.println("Nach dem Serialisieren");
		oos.close();
	}

	private static void deSerialisieren(String file) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Object obj = ois.readObject();
		Tier tier3 = (Tier) obj;
		System.out.println("Nach dem DeSerialisieren");
		System.out.println(tier3);
		ois.close();
	}



}
