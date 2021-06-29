package pak05_queue;

public class Nachricht implements Comparable<Nachricht> {
	private final int prioritaet; // Prioritaet der Nachricht
	private final String inhalt; // Inhalt der Nachricht

	public Nachricht(int prioritaet, String inhalt) {
		this.prioritaet = prioritaet;
		this.inhalt = inhalt;
	}

	@Override
	public int compareTo(Nachricht o) {
		System.out.println("Vergleich");
		if (this.prioritaet < o.prioritaet) {
			return -1;
		} else if (this.prioritaet > o.prioritaet) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getPrioritaet() {
		return prioritaet;
	}

	public String getInhalt() {
		return inhalt;
	}

	@Override
	public String toString() {
		return inhalt + " (Prio: " + prioritaet + ")";
	}

}
