package pak03_lists;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo04LinkedList {
	public static void main(String[] args) {
		List<Integer> listLinked = new LinkedList<>();
		Queue<Integer> listQueue = new LinkedList<>();
		Deque<Integer> listDeque = new LinkedList<>();

		// Fuellen der LinkedList mit dem List Interface
		for (int i = 0; i < 15; i++) {
			listLinked.add(i);
		}
		// Fuellen der LinkedList mit dem Queue Interface
		for (int i = 0; i < 15; i++) {
			listQueue.offer(i);
		}
		// Fuellen der LinkedList mit dem Deque Interface
		for (int i = 0; i < 15; i++) {
			listDeque.offerLast(i);
		}

		/*
		 * Retrieves, but does not remove, the head of this queue. This method differs
		 * from peek only in that it throws an exception if this queue is empty.
		 */
		System.out.println(listQueue.element()); // FiFo

		/*
		 * Retrieves, but does not remove, the head of this queue,or returns null if
		 * this queue is empty.
		 */
		System.out.println(listQueue.peek());
		/*
		 * Retrieves and removes the head of this queue,or returns null if this queue is
		 * empty.
		 */
		System.out.println(listQueue.poll());
		/*
		 * Retrieves and removes the head of this queue. This method differs from poll
		 * only in that it throws an exception if this queue is empty.
		 */
		System.out.println(listQueue.remove());
		
		/*
		 * Retrieves and removes the first element of this deque,or returns null if this deque is empty.
		 */
		System.out.println(listDeque.pollFirst());
		
		/*
		 * Retrieves and removes the last element of this deque,or returns null if this deque is empty.
		 */
		System.out.println(listDeque.pollLast());
		

	}
}
