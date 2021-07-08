package aufgaben.loesungen;

public class Kreis implements Comparable<Kreis> {
	private int radius;

	public Kreis(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
	
	@Override
	public int compareTo(Kreis k2) {
		return Integer.compare(radius, k2.radius);
	}

	@Override
	public String toString() {
		return "Kreis. R = " + radius;
	}
}
