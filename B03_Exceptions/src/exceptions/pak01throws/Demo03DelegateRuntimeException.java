package exceptions.pak01throws;

public class Demo03DelegateRuntimeException {
	public static void main(String[] args) {
		method01();
	}

	private static void method01() {
		method02();	
	}

	private static void method02() {
		method03();
	}

	private static void method03()throws ArrayIndexOutOfBoundsException {
		int[] zahlen = { 1, 2, 3 };
		int summe = 0;
		for (int i = 0; i <= zahlen.length; i++) {
			summe += zahlen[i];
		}
		System.out.println("Summe: " + summe);
		
	}
	
	
}
