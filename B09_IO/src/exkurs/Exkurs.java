package exkurs;

public class Exkurs {

	public static void main(String[] args) {

		/**
		 * Widening vor Boxing
		 */
		/**
		 * 
		 */
		dostuff((long)Integer.parseInt("123"));
	}

	private static void dostuff(short s) {
		System.out.println("Primitiv short");
	}
	
//	private static void dostuff(int i) {
//		System.out.println("Primitiv Integer");
//	}
//
//	private static void dostuff(Integer i) {
//		System.out.println("Wrapper Integer");
//
//	}
//
	private static void dostuff(long l) {
		System.out.println("Primitiv long");

	}
//
//	private static void dostuff(Long l) {
//		System.out.println("Wrapper Long");
//
//	}

}
