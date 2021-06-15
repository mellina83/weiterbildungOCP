package exceptions.pak04_tryMitRessourcen;

public class Demo03Whd {
	public static void main(String[] args) {
		System.out.println(go2());
	}

	private static String go() {
		boolean b = true;
		if (b) {
			try {
				int z = 0;
				int x = 1 / z;				
				return "Try";
			} catch (Exception e) {
				return "Catch";
			} finally {
				return "Finally";
			}
		}
		return "EndOfMethod";
	}
	
	private static String go2() {
		boolean b = true;
		if (b) {
			try(One o = new One(); Two o2 = new Two()){
				int z = 0;
				int x = 1 / z;				
				return "Try";
			} catch (Exception e) {
				return "Catch";
			}finally {
				boolean b1 = true;
				if(b1)
				return "Finally";
//				System.out.println("Finally");
			}
			
		}
		return "EndOfMethod";
	}
}
