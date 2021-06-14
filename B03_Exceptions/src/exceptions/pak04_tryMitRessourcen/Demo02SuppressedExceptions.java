package exceptions.pak04_tryMitRessourcen;

class C implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("C geschlossen");
		throw new Exception("Fehler beim close()");		
	}
	
}

public class Demo02SuppressedExceptions {
	
	public static void main(String[] args) {
		try(C c = new C()){	
			throw new Exception("Fehler im Try");
		} catch (Exception e) {
			System.out.println("HauptException: " + e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.out.println("Suppressed: " + t.getMessage());
			}		
		}finally {
			System.out.println("Finally");
		}
	}
	
}
