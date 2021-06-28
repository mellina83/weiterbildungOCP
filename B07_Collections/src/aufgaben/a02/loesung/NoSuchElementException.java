package aufgaben.a02.loesung;

public class NoSuchElementException extends RuntimeException {

	public NoSuchElementException() {
		super("Hilfe, keine Element gefunden!");
	}
	
	public NoSuchElementException(String message) {
		super(message);
	}
}
