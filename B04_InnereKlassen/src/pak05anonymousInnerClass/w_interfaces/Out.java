package pak05anonymousInnerClass.w_interfaces;

public class Out {
	public IPrinter iPrinter = new IPrinter() {

		@Override
		public void printText(String text) {
			System.out.println("Text: \n" + text);			
		}
		
//		public void papierStau() {
//			System.out.println("Papierstau");
//		}
		
	};
	
	public IPrinter iPrinterLambda = text -> System.out.println("Text: \n" + text);
	
	
	
	
	public void useAnoClass() {
		iPrinter.printText("Hallo Welt");
//		iPrinter.papierStau();
		IPrinter i1 = new IPrinter() {
			@Override
			public void printText(String text) {
				
			}
			public void papierStau() {
				System.out.println("Papierstau");
			}
			public IPrinter retThis() {
				papierStau();
				return this;
			}			
		}.retThis();
		
		new IPrinter() {		
			@Override
			public void printText(String text) {
				
			}
			public void papierStau() {
				System.out.println("Papierstau");
			}
		}.papierStau();
		
		iPrinterLambda.printText("Hallo Lambda");
		
		
	}
	
	public static void main(String[] args) {
		Out out = new Out();
		out.useAnoClass();
	}
}
