package pak01_threads;
/**
 * Mit dem Problem 'Race Condition' wird beschrieben was passieren kann, wenn 2
 * Konkurrierende Threads einen gemeinsamen Bereich modifizieren.
 * 
 * Solch Konkurriende Modifikationen und die daraus entstehenden Nebeneffekte,
 * sind h�ufig die Gr�nde f�r schwer auffindbare Programmierfehler.
 * 
 * Mithilfe des Schl�sselworts volatile laesst sich der Zugriff auf eine Variable
 * synchronisieren. Ist eine Variable als volatile deklariert, muss die JVM
 * sicherstellen, dass alle zugreifenden Threads ihre Kopien aktualisieren,
 * sobald die Variable geaendert wird.
 * 
 * Das Schl�sselwort volatile biete da nur eine geringe Abhilfe. Es kommt auf
 * die zu erstellende Anwendung an.
 * 
 * Weiterf�hrender Link -
 * http://www.angelikalanger.com/Articles/EffectiveJava/42.JMM-volatileIdioms/42.JMM-volatileIdioms.html
 * 
 * In diesem Artikel werden die Regeln f�r Volatile Attribute wie folgt
 * bezeichnet.
 * 
 * Man kann den Zugriff auf Variablen mit volatile statt mit Locks
 * synchronisieren, wenn:
 * 
 * Regel 1: der zu schreibende neue Wert der Variablen unabh�ngig vom
 * gegenw�rtigen Wert ist, und
 * 
 * Regel 2: die Variable unabh�ngig von anderen Variablen ist.
 * 
 * W�re Volatile in dem hier gezeigtem Beispiel somit ein L�sung?
 * 
 * Antwort: nein - Verletzte Regel Nr.1 count++ -> count = count + 1;
 */
/*
 *  					count = 0
 * 
 *		Thread 1					Thread 2
 * 
 *		count++;					count++; 
 * 
 * 		Ausgeschrieben:
 * 
 * 		count = count + 1			count = count + 1
 * 
 * 		Wiederum ausgeschrieben:
 * 
 * 		cpu1 = count (0)			cpu2 = count (0)
 * 		cpu1 + 1	 (1)			cpu2 + 1	 (1) 
 *      count = cpu1 (1)
 *      							count = cpu2 (1)
 *      
 *      				count = 1
 */
public class Demo11_RaceCondition {
	static final int iterations = 1_000_000;
	
	static volatile int count = 0;
	
	static class Increment implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < iterations; i++) {
				count++;
			}
			System.out.println("Thread: " + Thread.currentThread().getId() + " ist vorbei");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Runnable incrementTask = new Increment();
		
		Thread t1 = new Thread(incrementTask);
		Thread t2 = new Thread(incrementTask);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("count : " + count);
	}
}
