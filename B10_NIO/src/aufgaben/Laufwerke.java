package aufgaben;

/**
 * 
 * @A1 Definieren Sie in einer Klasse "Laufwerke" eine statische Methode
 *     "print". Die Methode soll für alle Laufwerke eine formatierte Tabelle auf
 *     der Konsole ausgeben. Die Tabelle soll folgende Form haben:
 * 
 *     | LW  |	Frei(MB)|	Belegt(MB) | Gesamt(MB)|
 *     | C:\ |	 	 ...|			...| 		...|
 *     | D:\ | 	 	 ...|		 	...| 		...|
 *      ...
 * 
 *     Die Spalte "LW" beinhaltet den Laufwerknamen. In den restlichen Spalten
 *     werden der freie, der belegte und der gesamte Speicher für das jeweilige
 *     Laufwerk angezeigt. Die Werte für die Spalten "Frei", "Belegt" und
 *     "Gesamt" ermitteln Sie bitte mit den Methoden "getFreeSpace" und
 *     "getTotalSpace" der Klasse java.io.File. Die Ausgaben erfolgen in
 *     Megabyte (MB).
 * 
 *     > Tipp: So können die aktuellen Laufwerke ermittelt werden:
 * 
 *     Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
 * 
 *     > Tipp: Mit der Methode 'format(String format, Object... args)' kann eine
 *     Tabelle mit den vordefinierten Spaltenbreiten erzeugt werden.
 * 
 * @A2 Sortieren Sie bitte die Daten nach der Spalte "Frei" und geben Sie die
 *     aus.
 * 
 * @Optional Gestalten Sie bitte die Anwendung interaktiv. Der Benutzer darf
 *           sich entscheiden ob die Speicherangaben in Gigabyte, Megabyte oder
 *           Kilobyte erscheinen.
 * 
 *
 */
public class Laufwerke {

}
