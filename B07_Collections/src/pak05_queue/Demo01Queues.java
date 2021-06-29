package pak05_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Warteschlangen oder Queues werden immer dann verwendet, wenn das FIFO Prinzip
 * für Nachrichten umgesetzt werden muss.
 * 
 * FIFO - First In First Out
 *
 */
public class Demo01Queues {

	public static void main(String[] args) {
//		System.out.println("LinkedList");
//		warteschlangeLinkedList01();
		System.out.println("PriorityQueue");
		warteschlangePriorityQueue();

	}

	private static void warteschlangePriorityQueue() {
		Queue<Nachricht> queue = new PriorityQueue<>();
//		Queue<Nachricht> queue = new LinkedList<>();
		fuelleQueue(queue);
		queue.forEach(System.out::println);
		
		System.out.println("----------");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	
	private static void fuelleQueue(Queue<Nachricht> queue) {
		queue.offer(new Nachricht(-5, "Java "));
		queue.offer(new Nachricht(1, "Feuer im vierten Stock"));
		queue.offer(new Nachricht(5, "Ruby on Rails"));
		queue.offer(new Nachricht(2, "Wassereinbruch im Keller"));
		queue.offer(new Nachricht(3, "Kotlin "));
		queue.offer(new Nachricht(1, "Feuer im zweiten Stock"));
		queue.offer(new Nachricht(4, "Python "));
		queue.offer(new Nachricht(1, "Feuer im dritten Stock"));
		queue.offer(new Nachricht(5, "Fortran "));
		queue.offer(new Nachricht(1, "Feuer im ersten Stock"));
	}

	private static void warteschlangeLinkedList01() {
		Queue<String> linkedQueue = new LinkedList<>();
		Deque<String> linkedDeque = new LinkedList<>();

		linkedQueue.add("0");
		linkedQueue.offer("1");
		linkedQueue.add("2");
		linkedQueue.offer("3");
		linkedQueue.add("4");


		System.out.println("linkedQueue.element()");
		/**
		 * @element() Retrieves, but does not remove, the head of this queue. This
		 *            method differs from peek only in that it throws an exception if
		 *            this queue is empty.
		 */
		System.out.println(linkedQueue.element());

		/**
		 * @peek() Retrieves, but does not remove, the head of this queue, or returns
		 *         null if this queue is empty.
		 */
		System.out.println("linkedQueue.peek()");
		System.out.println(linkedQueue.peek());

		/**
		 * @poll() Retrieves and removes the head of this queue, or returns null if this
		 *         queue is empty.
		 */
		System.out.println("linkedQueue.poll()");
		System.out.println(linkedQueue.poll());
		System.out.println(linkedQueue.poll());
		System.out.println(linkedQueue.poll());

		/**
		 * @remove() Retrieves and removes the head of this queue. This method
		 *           differs from poll only in that it throws an exception if this queue
		 *           is empty.
		 */
		System.out.println("linkedQueue.remove()");
		System.out.println(linkedQueue.remove());
		System.out.println(linkedQueue.remove());
//		System.out.println(linkedQueue.remove());
	}

}
