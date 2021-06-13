package pattern.immutable;

public final class MyImmutable {
	
	private final StringBuilder sb;
	
	public MyImmutable() {
		this("Hallo Welt");
	}
	public MyImmutable(String text) {
		this.sb = new StringBuilder(text);
	}
	public StringBuilder getSb() {
		return new StringBuilder(this.sb.toString());
	}
	
	public String toString() {
		return sb.toString();
	}
	
	public StringBuilder append(String text) {
		return this.getSb().append(text);
	}
	
}
