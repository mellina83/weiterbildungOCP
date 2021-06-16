package pak03memberclass.pak03Vererbung;

public class Shoe {
	void out() {
		System.out.println("Shoe");
	}
	
	class LeatherShow extends Shoe{
		void what() {
			Shoe.this.out();			
		}
		
		void out() {
			super.out();
			System.out.println("LeatherShoe");
		}
	}
	
	public static void main(String[] args) {
		new Shoe().new LeatherShow().what();
	}
}
