package exceptions.pak04_tryMitRessourcen;

import java.io.IOException;

public class Demo02aSuppressed {

	static class MyCloseable implements AutoCloseable {

		@Override
		public void close() throws IOException {
			throw new IOException("Fehler im close()");
		}

	}

	public static void main(String[] args) {
		try (MyCloseable mc = new MyCloseable()) {
			throw new ArrayIndexOutOfBoundsException("Array Fehler");
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("HauptException: " + ae.getMessage());
			Throwable suppressed = ae.getSuppressed()[0];
			System.out.println("Suppressed: " + suppressed.getMessage());

		} catch (IOException ioe) {
			System.out.println("Catched IOException");
		}
	}

}

class Animals {
	class Lamb implements AutoCloseable {
		public void close() {
			throw new RuntimeException("a");
		}
	}

	public static void main(String[] args){
		try {
			new Animals().run();			
		}catch(IOException ioe) {
			
		}
	}

	public void run() throws IOException  {
		try (Lamb l = new Lamb();) {
			throw new IOException();
		} catch (Exception e) {
			//Rethrow
			throw e;
//			throw new Exception();
//			e = new IOException();
//			throw e;			
		}
	}
}
