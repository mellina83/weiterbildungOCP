package io03_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @SERIALISIEREN
 *
 * @writeObject (Object obj) serialisiert nur das Objekt. Statische Elemente der
 *              Klasse werden nicht mitserialisiert, außer der serialVersionUID.
 * 
 * 
 *              Damit ein Objekt serialisiert werden kann:
 * 
 *              Die Klasse muss 'Serializable' implementieren
 * 
 *              - Alle Attribute müssen entweder primitiv sein oder auch
 *              Serializable (oder transient)
 * 
 *              - Attribute aus der Nicht-Serializable Basisklasse werden beim
 *              Serialisieren übersprungen
 * 
 *              - transiente Attribute werden beim Serialisieren übersprungen
 * 
 * @DESERIALISIEREN
 * 
 * @readObject() Beim Deserialisieren wird kein Konstruktor der
 *               Serializable-Klasse aufgerufen, ABER der default-Konstruktor
 *               der Nicht-Serializable Basisklasse(Elternklasse).
 * 
 *               Also: !!!Die Nicht-Serializable Basisklasse muss einen
 *               default-Konstruktor haben!!!
 *
 *
 * @JavaBean Alle Attribute sind private
 * 
 *           Notwendige öffentliche Zugriffsmethoden (Getter/Setter)
 *           
 *           öffentlicher default Konstruktor
 *           
 *           equals & hashcode & toString sind überschrieben
 *           
 *           implements Serializable
 * 
 */
public class Demo01Rules {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String file = "./serializable/test01";

		serialisieren(file);
		deSerialisieren(file);
	}

	private static void deSerialisieren(String file) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Object obj = ois.readObject();
		Teilnehmer t01 = (Teilnehmer)obj;
		System.out.println("nach dem Deserialisieren");
		System.out.println(t01);
		ois.close();
	}

	private static void serialisieren(String file) throws IOException {
		Teilnehmer t01 = new Teilnehmer("Gutenberg", "Johannes");
		
		System.out.println("Vor dem Serialisieren");
		
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(t01);
		oos.close();
		os.close();
		
	}

}
