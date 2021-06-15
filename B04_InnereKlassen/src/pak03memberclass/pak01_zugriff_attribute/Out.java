package pak03memberclass.pak01_zugriff_attribute;

public class Out {
	private int number1 = 8;
	private int number2 = 10;
	
	class In{
		
		private int number2 = 12;
		
		void see() {
			System.out.println("number1: " + number1); //8
			System.out.println("number1: " + Out.this.number1); //8
			
			System.out.println("number2: " + number2);//12
			System.out.println("number2: " + this.number2);//12
			System.out.println("number2: " + Out.this.number2);//10
			System.out.println("number2: " + Out.In.this.number2);//12
			
		}
		
	}
}
