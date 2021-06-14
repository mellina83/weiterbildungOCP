package exceptions.pak03_vererbung;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

class A{
	public void doIt() throws IOException{}
	
	public void doIt2() {}
}
/*
 * 
 * Regeln fuer das Override der throws Klausel
 */
class B extends A{
	//Beim Override duerfen die checked Exceptions nicht verallgemeinert werden.
//	@Override
//	public void doIt() throws Exception {}
	
	//Spezialisierung ist erlaubt
//	@Override
//	public void doIt() throws FileNotFoundException {}
	
	//Weglassen ist erlaubt
//	@Override
//	public void doIt() {
//		try {
//			throw new Exception();			
//		}catch(Exception e) {
//			
//		}
//	}
	//Overload, kein Override
	public void doIt(int zahl) throws Exception {}
	
	//Anders als die checked Exception unterliegen die RuntimeExceptions(unchecked)
	//diesen Regeln nicht
	public void doIt2()throws RuntimeException {}
}




public class Demo01_Vererbung {
	public static void main(String[] args) {
		A a1 = new A();
		try {
			a1.doIt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		A a2 = new B();
		try {
			a2.doIt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
