package exceptions.pak01throws;

import java.io.FileNotFoundException;
/*
 * Handle or declare
 * Checked Exception erzwingen eine Behandlung oder Delegation
 */
public class Demo02MultipleThrows {
	public static void main(String[] args) throws Exception{
		erzeugeMultipleExceptions();
		
	}

	private static void erzeugeMultipleExceptions()throws IndexOutOfBoundsException, NullPointerException, FileNotFoundException, ReflectiveOperationException {
		for (int i = 0; i < 10; i++) {
			switch (i) {
			case 1: {
				throw new IndexOutOfBoundsException();
			}
			case 2: {
				throw new NullPointerException();
			}
			case 3: {
				throw new FileNotFoundException();
			}
			case 4 : {
				throw new ReflectiveOperationException();
			}
			}
		}

	}
}
