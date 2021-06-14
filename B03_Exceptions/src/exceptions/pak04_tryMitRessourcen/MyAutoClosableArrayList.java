package exceptions.pak04_tryMitRessourcen;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class MyAutoClosableArrayList<E> extends ArrayList<E> implements AutoCloseable {

	@Override
	public void close()throws Exception{
		this.clear();
		System.out.println("Liste wurde bereinigt");
	}

}
