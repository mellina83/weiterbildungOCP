package pak04localInnerClass;

public class Demo01LocalClass {
	private static String staticAttr = "Static";
	private String instanceAttr = "Instance";
	
	public static void main(String[] args) {
//		staticKontext();
		new Demo01LocalClass().instanceKontext();
	}

	private static void staticKontext() {
		
		String text = "Hallo Welt";
		
		class Inside{
			public Inside() {
				System.out.println(staticAttr);
				System.out.println(text);
//				Cannot make a static reference to the non-static field instanceAttr
//				System.out.println(instanceAttr);
				
			}
			
			public void changeString() {
				staticAttr = staticAttr + " changed";
				//Local variable text defined in an enclosing scope must be final or effectively final
//				text = text + " changed";
				Demo01LocalClass d1 = new Demo01LocalClass();
				System.out.println(d1.instanceAttr);
			}
			
//			static void staticGo() {
//				
//			}
		}
		
		Inside in = new Inside();
		in.changeString();
		System.out.println(staticAttr);
	}
	
	private void instanceKontext() {
		class Inside{
			public Inside() {
				System.out.println(staticAttr);
				System.out.println(instanceAttr);
			}
			
			public void changeString() {
				staticAttr = staticAttr + " changed";
				instanceAttr = instanceAttr + " changed";
			}
		}
		
		Inside in = new Inside();
		in.changeString();
		System.out.println(staticAttr);
		System.out.println(instanceAttr);
		
	}
}
