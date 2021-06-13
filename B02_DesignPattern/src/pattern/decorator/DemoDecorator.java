package pattern.decorator;

import java.time.LocalDate;

public class DemoDecorator {
	public static void main(String[] args) {
		/*
		 * Normale Nutzung ohne Decorator
		 */
		Kaufvertrag kaufVertrag = new Kaufvertrag();
		kaufVertrag.freigeben();
		/*
		 * Nutzung des Addons Archivierung
		 */
		AddonArchivierung kaufVertragMitArchivierung = new AddonArchivierung(kaufVertrag);	
		kaufVertragMitArchivierung.freigeben();
		kaufVertragMitArchivierung.kuendigen(LocalDate.now());
		//Zusaetliche Funktionalitaet
		kaufVertragMitArchivierung.archivieren();
		
		AddonVerschluesselung kaufVertragMitBeidem = new AddonVerschluesselung(kaufVertragMitArchivierung);
		kaufVertragMitBeidem.freigeben();
		kaufVertragMitBeidem.kuendigen(LocalDate.now());
		kaufVertragMitBeidem.verschluesseln();
		((AddonArchivierung)kaufVertragMitBeidem.getVertrag()).archivieren();
	}
}
