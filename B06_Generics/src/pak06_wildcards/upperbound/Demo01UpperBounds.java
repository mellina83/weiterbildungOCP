package pak06_wildcards.upperbound;
/*
 * Upperbound leiten wir mit extends ein
 */
interface UpperBounded<E extends Number>{}

//Syntax error on token "?", Identifier expected
//interface UpperBounded02<? extends Number>{}

//Syntax error on token "?", Identifier expected
//public class Demo01UpperBounds<? extends Number> {
	
public class Demo01UpperBounds<E extends Number> {
	
	public <N> void method01(N n) {}

	public <N extends Number> void method02(N n) {}
	
	public <T extends Number> void method03(PunktGen<? extends Number> punkt) {}
	
	public <T extends Number> void method04(PunktGen<?> punkt) {}
	
	public <T extends Number> void method05(PunktGen<T> punkt) {}
	
	public <T extends Number> void method06(PunktGen<Integer> punkt) {}
	
	public static void main(String[] args) {
		Demo01UpperBounds<Number> d01 = new Demo01UpperBounds<>();
	}
}
