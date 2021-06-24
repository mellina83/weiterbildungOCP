package pak01;

public class Demo01Equals {
	public static void main(String[] args) {
		String s1 = "Hallo";
		String s2 = new String("Hallo");
		
		System.out.println(s1 == s2);//false
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		System.out.println(o1.hashCode() == o2.hashCode());//false
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		
		System.out.println(s1.hashCode() == s2.hashCode());//true
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
		System.out.println(o1.equals(o2)); //false
		System.out.println(s1.equals(s2)); //true
		
	}
}
