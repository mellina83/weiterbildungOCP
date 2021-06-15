package pak03memberclass;

public class MoebliertesHaus {
	String s = "Haus";
	
	class Raum{
		String s = "Raum";
		
		class Stuhl{
			String s = "Stuhl";
			
			void output() {
				System.out.println(s); 		//Stuhl
				System.out.println(this.s); //Stuhl
				System.out.println(Stuhl.this.s);//Stuhl
				System.out.println(Raum.this.s); //Raum
				System.out.println(MoebliertesHaus.this.s);//Haus
			
				System.out.println(MoebliertesHaus.Raum.Stuhl.this.s);//Stuhl
				
			}
		}
		
	}
	
	void go() {
		System.out.println(MoebliertesHaus.this.s);
	}
	public static void main(String[] args) {
		MoebliertesHaus h = new MoebliertesHaus();
		MoebliertesHaus.Raum r = h.new Raum();
		MoebliertesHaus.Raum.Stuhl s = r.new Stuhl();
		s.output();
		
		System.out.println("----------------------");
		new MoebliertesHaus().new Raum().new Stuhl().output();
	}
	
}
