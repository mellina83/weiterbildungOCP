package ml.novytska.Aufgabe_02_Lambda;



interface StringProcessor {
	void process(String s);
}

public class TestLambda {// implements StringProcessor{
//	@Override
//	public void process(String s) {
//		System.out.println(s);
//		
//	}
//	public abstract class TestLambdaA implements StringProcessor{}

	public static void main(String[] args) {
		String s1 = "Hallo Welt!";
		String s2 = "Wir arbeiten mit Methoden Referenzen";
		String s3 = "Java ist auch eine Insel";

//		mit anonymes Klass
		StringProcessor c = new StringProcessor() {

			@Override
			public void process(String s) {
				System.out.println(s);

			}

		};
		c.process(s1);
//		

		StringProcessor c1 = (String s) -> {
			System.out.println(s);
		};
		c1.process(s1);

		StringProcessor c2 = s -> System.out.println(s);
		c1.process(s2);

		StringProcessor c3 = System.out::println;
		c3.process(s3);

		print(c3, s3);
		print(new StringProcessor() {

			@Override
			public void process(String s) {
				System.out.println(s);

			}

		}, s1);
		print((String s) -> {
			System.out.println(s);
		}, s1);
		print(s -> System.out.println(s), s2);
		print(System.out::println, s3);

	}

	private static void print(StringProcessor sp, String str) {
		sp.process(str);
	}
}
