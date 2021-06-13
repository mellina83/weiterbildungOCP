package pattern.immutable;

public class App {
	public static void main(String[] args) {
		MyImmutable mi1 = new MyImmutable("mi1 Text");
		
		StringBuilder sb1 = mi1.getSb();
		sb1.append(" das darf nicht sein");
		
		System.out.println(sb1 == mi1.getSb());
		
	}
}
