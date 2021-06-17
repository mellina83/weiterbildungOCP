package pak01_functional;

interface StringCreator{
	String create();
}

public class Demo05_a_KonstruktorenReferenz {
	public static void main(String[] args) {
		demo01();
	}

	private static void demo01() {
		//Anonyme Klasse
		StringCreator sc01 = new StringCreator() {			
			@Override
			public String create() {
				return new String();
			}
		};		
		String s1 = sc01.create();
		
		//Lambda
		StringCreator sc02 = () -> new String();		
		String s2 = sc02.create();
		
		StringCreator sc03 = String::new;
		
		String s3 = sc03.create();
		System.out.println(s3.getClass());
		
		System.out.println(sc03.create() == sc03.create());
		System.out.println(sc03.create().hashCode());
		
	}
}
