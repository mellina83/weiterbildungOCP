package pak01_functional;

interface I01 {
	void go() throws Exception;
}

public class LambdaException {
	public static void main(String[] args) {
		I01 i01 = () -> {
			System.out.println("Hallo Welt");
//			try {
				throw new Exception();				
//			}catch(Exception e) {
//				
//			}
		};
		
		I01 i02 = new I01() {			
			@Override
			public void go(){
//				throw new Exception();				
			}
		};

		try {
			i01.go();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		I01 i03 = LambdaException::goStatic;
		try {
			i03.go();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void goStatic() throws Exception{
		throw new Exception();
	}
}
