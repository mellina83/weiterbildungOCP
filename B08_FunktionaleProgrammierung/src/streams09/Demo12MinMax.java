package streams09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @min(Comparator) Returns the minimum element of this stream according to the
 *                  provided Comparator. - Optional<T>
 *
 * @max(Comparator) Returns the maximum element of this stream according to the
 *                  provided Comparator. - Optional<T>
 *
 */
public class Demo12MinMax {

	public static void main(String[] args) {
		List<Kreis> list = new ArrayList<>();
		
		for (int i = 0; i < 10_000; i++) {
			list.add(new Kreis(new Random().nextInt(500_000)));
		}
		
		/**
		 * Comparator über default Methoden des Comparator Interface
		 */
		Comparator<Kreis> compNatural = Comparator.naturalOrder();
		Comparator<Kreis> compReverse = Comparator.reverseOrder();
	
		/**
		 * Consumer für die Ausgabe unserer Daten
		 */
		Consumer<Kreis> consumerKreis = kreis -> System.out.println("Kreis = " + kreis);

//		Optional<Kreis> optKreis01 = list.stream().max(Comparator.naturalOrder());
		Optional<Kreis> optKreis01 = list.stream().max(Kreis::compareTo);
		
		optKreis01.ifPresent(consumerKreis);
		
		/**
		 * Min, das kleinste Element aus dem Stream
		 */
		Optional<Kreis> optKreis02 = list.stream().min(Comparator.naturalOrder());
	
		if(optKreis02.isPresent()) {
			System.out.println("Kreis = " + optKreis02.get());
		}
	}

}
