package pak01;

public class Out {
	
	static String sOut = goOut();
	static String sOut2 = In.goIn();
	
	private static class In{
		static String s = goIn();
		
		static {
			System.out.println("In");
		}
		
		static String goIn() {
			System.out.println("goIn");
			return "";
		}
	}
	
	static String goOut() {
		System.out.println("goOut");
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println("Hallo");
	}
}
