package aufgaben.a04;

/***
 * @Thema 'Browser History - Deque'
 * 
 * @Vorbereitung Definieren Sie bitte die Klasse `BrowserHistory` und gestalten
 *               Sie Ihre Tests nach folgenden Beschreibungen.
 * 
 * @Aufgabe01 Browser-History wird angelegt, die imstande ist f�nf URLs zu
 *            merken (inklusive der zuletzt ge�ffneten aktuell angezeigten URL).
 * 
 *            BrowserHistory h = new BrowserHistory();
 * 
 * @Aufgabe02 Die n�chsten f�nf `open`-Aufrufe f�llen die Browser-History
 *            komplett. Der zuletzt �bergebene String 'u5.com' wird als aktuell
 *            angezeigte Seite gespeichert.
 * 
 *            h.open("u1.com");
 *            h.open("u2.com");
 *            h.open("u3.com");
 *            h.open("u4.com");
 *            h.open("u5.com");
 *            System.out.println(h.getCurrent()); // u5.com
 * 
 * @Aufgabe03 Der n�chste `open`-Aufruf f�gt 'u6.com' der Browser-History hinzu.
 *            Da die maximale Gr��e der gespeicherten URLs bereits erreicht
 *            wurde, wird der �lteste Eintrag 'u1.com' gel�scht. Der zuletzt
 *            hinzugef�gte String 'u6.com' wird als aktuell angezeigte Seite
 *            gespeichert.
 * 
 *            h.open("u6.com");
 *            System.out.println( h.getCurrent() ); // u6.com
 * 
 * @Aufgabe04 Die n�chsten vier `openPrevious`-Aufrufe lassen den Client
 *            r�ckw�rts navigieren: zu 'u5.com', 'u4.com', 'u3.com', 'u2.com'.
 *            
 *            Nach jedem Aufruf wechselt auch die aktuell angezeigte Seite. Nach
 *            dem vierten `openPrevious`-Aufruf ist 'u2.com' die aktuelle Seite.
 * 
 *            h.openPrevious();
 *            h.openPrevious();
 *            h.openPrevious();
 *            h.openPrevious();
 *            System.out.println( h.getCurrent() ); // u2.com
 * 
 * @Aufgabe05 Der weitere Versuch `openPrevious` aufzurufen verursacht eine
 *            Exception, da die Browser-History keine 'previous'-Eintr�ge mehr
 *            hat. Die 'u2.com' bleibt als die aktuell angezeigte Seite
 *            gespeichert.
 * 
 *            try {
 *            	h.openPrevious();
 *            } catch (IllegalStateException e) {
 *            	System.out.println( e.getMessage() ); // previous history is empty
 *            }
 *            System.out.println( h.getCurrent() ); // u2.com
 * 
 * @Aufgabe06 Die n�chsten vier `openNext`-Aufrufe lassen den Client vorw�rts
 *            navigieren: zu 'u3.com', 'u4.com', 'u5.com', 'u6.com'. Nach dem
 *            vierten `openNext`-Aufruf ist 'u6.com' die aktuelle Seite und die
 *            Browser-History f�r die 'previous'-Eintr�ge ist wieder voll.
 * 
 *            h.openNext();
 *            h.openNext();
 *            h.openNext();
 *            h.openNext();
 *            System.out.println( h.getCurrent() ); // u6.com
 * 
 * @Aufgabe07 Der weitere Versuch `openNext` aufzurufen verursacht eine
 *            Exception, da es keine 'next'-URLs mehr gibt. Die 'u6.com' bleibt
 *            die aktuelle Seite.
 * 
 *            try {
 *            	System.out.println( h.openNext() );
 *            } catch (IllegalStateException e) {
 *            	System.out.println( e.getMessage() );// next history is empty
 *            }
 *            System.out.println( h.getCurrent() ); // u6.com
 * 
 */
public class Aufgabe {

}
