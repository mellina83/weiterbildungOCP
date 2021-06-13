package exceptions.pak02tryCatch;

public class Demo01TryCatch {
	public static void main(String[] args) {
		try {
			erzeugeUncheckedException();			
		}catch(RuntimeException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			erzeugeCheckedException();
		} catch (Exception e) {			
			System.out.println("in der main: " + e.getMessage());
		}
		
		System.out.println("Main beendet");
	}
	
	public static void erzeugeUncheckedException()throws RuntimeException {
		for (int i = 0; i < 10; i++) {
			if(i == 6) {
				throw new RuntimeException("i war 6");
			}
		}
		System.out.println("Methode beendet");
	}
	
	public static void erzeugeCheckedException() throws Exception {
		for (int i = 0; i < 10; i++) {
			if(i == 6) {
				try {
					throw new Exception("i war 6");					
				}catch(Exception e) {
					System.out.println("in der Methode: " + e.getMessage());
//					throw new Exception("Inside Catch");
					throw e; //rethrow einer vorhandenen Exception
				}
			}
		}
		System.out.println("Methode beendet");
	}
	
}
