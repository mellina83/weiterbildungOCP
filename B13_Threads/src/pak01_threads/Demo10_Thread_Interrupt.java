package pak01_threads;

class Demo10_Endless_Thread extends Thread{
	@Override
	public void run() {
		while(!this.isInterrupted()) {
			/*
			 * Wenn ein anderer Thread zu diesem Thread interrupt() aufruft, wird dieser Thread auf 
			 * interrupted gesetzt.
			 * 
			 * - Wenn die sleep- Methode gerade laeuft, wirft sie sofort die
			 * InterruptedException.
			 * 
			 * - Wenn die InteruptedException geworfen wird, wird dieser Thread auf "nicht interrupted"
			 * zurueckgesetzt.
			 * 
			 * - Wenn die sleep Methode nach dem Setzen von "interrupted" aufgerufen wird,
			 * wirft sie sofort die InterruptedException.
			 */		
			try {
//				this.interrupt();
//				System.out.println("Interrupt gesetzt: " + this.isInterrupted());
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				System.out.println("Thread: " + getId() +  " wurde unterbrochen");
				break;
			}
			System.out.println("Thread: " + getId() + " : " + isInterrupted());
		}
		System.out.println("Thread: " + this.getId() + " ist fertig " + isInterrupted());
	}
}


public class Demo10_Thread_Interrupt {
	public static void main(String[] args) {
		Thread endless = new Demo10_Endless_Thread();
		endless.start();
		
		ThreadUtility.pause(1000);
		
		System.out.println("Main soll endless unterbrechen");
		
		endless.interrupt();
		
		System.out.println("End of main");
		
	}
}
