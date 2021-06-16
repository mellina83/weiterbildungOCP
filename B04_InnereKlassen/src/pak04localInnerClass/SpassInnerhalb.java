package pak04localInnerClass;

public class SpassInnerhalb {
	public static void main(String[] args) {
		wirHabenSpass(5);
	}

	private static void wirHabenSpass(final int param) {
		int i = 2;
		final int j = 0;
		
		i = 0;//<-- dies zerstoert das effetivly final
		Person p = new Person();
		p.name = "";
		
		for (int count = 0; count < 5; count++) {
			class Innerhalb{
				static final String beschreibung = "Lokale Klasse";
				private String s = "Java";
				/*
				 * Die Variablen param, i, j und p muessen final oder effectively final sein
				 */
				public Innerhalb() {
					System.out.println(s);
					System.out.println(beschreibung);
					//Local variable i defined in an enclosing scope must be final or effectively final
//					System.out.println(i);
					System.out.println(param);
					System.out.println(j);
//					System.out.println(count);
					p.name = "";
				}
			}
		}
//		Innerhalb in = new Innerhalb();
		abstract class Innerhalb {
			abstract void goAbstract();
		}
		
		class SubInnerhalb extends Innerhalb{
			@Override
			void goAbstract() {
				
			}			
		}
		
		SubInnerhalb sub1 = new SubInnerhalb();
		Innerhalb sub2 = new SubInnerhalb();
		
		{
			class Sinnbefreit{}
		}
//		Sinnbefreit sinnlos1;
		
//		interface I1{}
		
	}
}
class Person {
	public String name = "Person";
}
