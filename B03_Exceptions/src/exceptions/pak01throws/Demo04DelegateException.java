package exceptions.pak01throws;

public class Demo04DelegateException {
	public static void main(String[] args)throws Exception {
		method01();
	}

	private static void method01()throws Exception {
		method02();
	}

	private static void method02() throws Exception{
		method03();
	}

	private static void method03() throws Exception {
		int[] zahlen = { 1, 2, 3 };
		int summe = 0;
		for (int i = 0; i <= zahlen.length; i++) {
			summe += zahlen[i];
		}
		System.out.println("Summe: " + summe);
	}
}
