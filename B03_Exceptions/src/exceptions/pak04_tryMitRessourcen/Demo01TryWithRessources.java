package exceptions.pak04_tryMitRessourcen;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class One implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("Close - One");
	}
}
class Two implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("Close - Two");
	}
}
public class Demo01TryWithRessources {
	public static void main(String[] args) {
//		demoWithOutRessources();
//		demoTryWithRessources();
//		demoTryWithOwnRessource01();
//		demoTryWithOwnRessource02();
		demoReihenfolge();
	}

	
	
	
	private static void demoReihenfolge() {
		/*
		 * Die Ressourcen werden in umgekehrter Reihenfolge
		 * geschlossen, wie sie geoeffnet wurden.
		 */		
		try(One one = new One();Two two = new Two();){
			System.out.println("Try");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Catch");
		}finally {
			System.out.println("Finally");
		}	
	}

	private static void demoTryWithOwnRessource02() {
	
		try(MyAutoClosableArrayList<String> myList = new MyAutoClosableArrayList<String>()){
			myList.add("Hallo");
			myList.add("Welt");
			
			myList.forEach(System.out::println);
			throw new Exception("Fehler ist aufgetreten");
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			myList.add("");
		}finally {
			System.out.println("finally");
//			myList.add("");
		}
		
	}

	private static void demoTryWithOwnRessource01() {
		MyAutoClosableArrayList<String> myList = new MyAutoClosableArrayList<String>();	
		try {
			myList.add("Hallo");
			myList.add("Welt");
			
			myList.forEach(System.out::println);
			
		}catch(Exception e) {
			
		}finally {
			try {
				myList.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

	private static void demoTryWithRessources() {
		File file = new File("c:\\Java\\test.txt");
		
		try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
			while(br.ready()) {
				System.out.println(br.readLine());
			}
		}catch(Exception e) {
			
		}
		
	}

	private static void demoWithOutRessources() {
		File file = new File("c:\\Java\\test.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
//			fr.close();
		}catch(Exception e) {
			
		}finally {
			try {				
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	
}
