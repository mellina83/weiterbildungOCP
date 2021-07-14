package io03_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Demo04HasA_notSerializable_Manual {

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
		String file = "./serializable/Computer02";
		
		Computer c01 = new Computer();
		c01.cpu = new CPU();
		c01.model = "Amstrad III";
		System.out.println(c01);
		
		computer2File(file, c01);
		
		Computer c02 = file2Computer(file);
		System.out.println(c02);
	}
	
	private static Computer file2Computer(String file) throws Exception {
		System.out.println("Objekt soll Deserialisiert");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		/**
		 * Was deserialisiert werden kann, wird deserialisiert
		 */
		Computer comp = (Computer)ois.readObject();
		
		/**
		 * Manuelle auslesen und zuweisen der weiteren Informationen aus der Datei
		 */
		CPU cpu = new CPU();
		cpu.name = ois.readUTF();
		cpu.hz = ois.readLong();
		
		comp.cpu = cpu;
		
		return comp;
	}
	
	private static Object file2Object(String file) throws Exception {
		System.out.println("Objekt soll Deserialisiert");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	private static void computer2File(String file, Computer comp) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		/**
		 * Das was serialisiert werden kann, wird serialsiert
		 */
		oos.writeObject(comp);
		
		/**
		 * Den Rest serialisieren wir von hand.
		 */
		long hz = comp.cpu.hz;
		String name = comp.cpu.name;
		
		/**
		 * Reihenfolge ist wichtig wenn wir das Object wieder deserialisieren.
		 */
		oos.writeUTF(name);
		oos.writeLong(hz);
//		oos.writeLong(comp.cpu.hz);
//		oos.writeUTF(comp.cpu.name);
		
		oos.close();
		System.out.println("Objekt wurde Serialisiert");
	}
	
	private static void object2File(String file, Serializable serObj) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));	
		oos.writeObject(serObj);
		oos.close();
		System.out.println("Objekt wurde Serialisiert");
	}

}
