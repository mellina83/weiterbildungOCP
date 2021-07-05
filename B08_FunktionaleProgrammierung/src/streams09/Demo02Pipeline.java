package streams09;

import java.util.stream.Stream;

/**
 * 
 * @Pipeline Eine Pipeline ist eine Abfolge von Operationen auf einen
 *           Datenstrom. (Stream)
 * 
 *           Sie besteht aus einer Quelle - Liste, Collection, Array usw- ,
 *           mehreren intermediären Operationen (distinct(), limit(), filter(),
 *           usw...) und "einer" terminalen Operation (terminal operation).
 * 
 *           Die Terminal Operation schließt den Stream abschließend. Alle
 *           Streams sind vom Typ (AutoClosable)
 * 
 *           Kurz: Mehrere Intermediates Operations, die dann mit einer Terminal
 *           Operation abgeschlossen werden, fasst man zu einer Pipeline
 *           zusammen. (Verkettete Aufrufe)
 *
 */
public class Demo02Pipeline {

	public static void main(String[] args) {
		demoPipeline01();

	}

	private static void demoPipeline01() {
		/**
		 * Pipeline mit einer Datenquelle aus mehreren festen Werten erstellen
		 */
		Stream<String> stream01 = Stream.of(null, "Jan", "Feb", "Maerz", "April");

		/**
		 * Nachfolgende anweisung führt zu einer java.lang.IllegalStateException: stream
		 * has already been operated upon or closed
		 * 
		 * Jede Intermediate Operation erzeugt einen neuen Stream, wodurch der
		 * vorhergehende Stream verbraucht wurde.
		 * 
		 * Daher ist es empfohlen in einer Pipeline zu arbeiten
		 */
		// stream01.peek(str->System.out.println("Peek " + str));

		/**
		 * Intermediate Operation -- Intermediates sind Träge, ohne Terminal Operation
		 * werden diese nicht ausgeführt
		 */
		Stream<String> stream02 = stream01.limit(3);

		System.out.println("stream01 == stream02 " + (stream01 == stream02));

		Stream<String> stream03 = stream02.filter(s -> s != null);

		System.out.println("stream02 == stream03 " + (stream02 == stream03));

		/**
		 * Terminal Operation - damit wird die Stream Abarbeitung gestartet
		 */
		stream03.forEach(System.out::println);

		System.out.println("Jetzt eine Pipeline einen Aufruf");
		Stream.of("Jan", "Feb", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
				"November", "Dezember")
				.skip(4)
				.peek(str -> System.out.print("peek : " + str + "-----"))
				.limit(3)
				.filter(s -> s != null)
				.forEach(System.out::println);

	}

}
