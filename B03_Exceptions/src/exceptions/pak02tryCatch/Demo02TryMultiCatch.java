package exceptions.pak02tryCatch;

import java.io.FileNotFoundException;

public class Demo02TryMultiCatch {
	public static void main(String[] args) {
		//Java 6 like Try Multiple Catch
		try {
			erzeugeMultipleExceptions();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
		//Java 7 and above Try Multiple Catch
		try {
			erzeugeMultipleExceptions();
		}catch(IndexOutOfBoundsException | NullPointerException | FileNotFoundException | ReflectiveOperationException e) {
			
		}

	}

	private static void erzeugeMultipleExceptions() throws IndexOutOfBoundsException, NullPointerException,
			FileNotFoundException, ReflectiveOperationException {
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
			case 4: {
				throw new ReflectiveOperationException();
			}
			}
		}

	}
}
