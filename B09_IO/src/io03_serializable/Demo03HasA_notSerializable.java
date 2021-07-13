package io03_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Demo03HasA_notSerializable {

	/**
	 * Wird von einer Bibliothek zur Verfügung gestellt und kann von uns nicht
	 * verändert werden.
	 */
	static class CPU {
		public String name;
		public long hz;

		public CPU() {
			System.out.println("CPU Default Konstruktor");
			this.name = "Schneider";
			this.hz = 1234;
		}
		
		@Override
		public String toString() {
			return "CPU [name=" + name + ", hz=" + hz + "]";
		}
	}
	
	/**
	 * Wird von uns Entwickelt und kann/muss angepasst werden.
	 */
	static class Computer implements Serializable{
		public String model;
		public transient CPU cpu;
		
		public Computer() {
			System.out.println("Computer Default Konstruktor");
		}
		
		@Override
		public String toString() {
			return "Computer [model=" + model + ", cpu=" + cpu + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		String file = "./serializable/Computer01";
		
		Computer c01 = new Computer();
		c01.cpu = new CPU();
		c01.model = "Amstrad III";
		System.out.println(c01);
		
		object2File(file, c01);
		
		Computer c02 = (Computer)file2Object(file);
		System.out.println(c02);
	}
	
	private static Object file2Object(String file) throws Exception {
		System.out.println("Objekt soll Deserialisiert");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	private static void object2File(String file, Serializable serObj) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));	
		oos.writeObject(serObj);
		oos.close();
		System.out.println("Objekt wurde Serialisiert");
	}

}
