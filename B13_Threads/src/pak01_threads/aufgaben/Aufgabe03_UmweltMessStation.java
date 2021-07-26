package pak01_threads.aufgaben;

/**
 * Messung von Feinstaubwerten:
 * 
 * In einem Thread werden alle 100 Millisekunden Feinstaubwerte gemessen.
 * 
 * 
 * Simuliert wird jede Messung durch das Generieren einer Zufallszahl, die im
 * Bereich des vorherigen Wertes +/- 8 Mikrogramm liegt. Der Anfangswert kann
 * auf 15 Mikrogramm gesetzt werden.
 * 
 * 
 * In einem anderen Thread werden die drei letzten vorhandenen Messungen
 * analysiert (1 mal pro Sekunde). Falls in diesen drei Messungen der st�tige
 * Abfall erkannt wird, wird die Tendenz auf der Konsole visualisiert. Dasselbe
 * zur st�tigen Steigung.
 * 
 * 
 * Im dritten Thread werden Mitteilungen ausgegeben, falls die aktuelle
 * Feinstaubkonzentration einen Grenzwert �berschreitet (>50) (Erh�hte
 * Belastung) oder unterschreitet (<8)(Sehr saubere Luft). - Auch die Kontrollen
 * werden nur periodisch (1 Mal in 2 Sek) durchgef�hrt.
 */
public class Aufgabe03_UmweltMessStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
