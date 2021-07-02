package data;

public class OptionalEmptyException extends RuntimeException {

	public OptionalEmptyException() {
		super();
	}
	public OptionalEmptyException(String message) {
		super(message);
	}
}
