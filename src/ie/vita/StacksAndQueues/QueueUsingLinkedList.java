/* This class provides an implementation
 * of a queue via Linked List
 * 
 * Use:
 * QueueUsingLinkedList<Item> queue = new QueueUsingLinkedList<>();
 *  
 * */


package ie.vita.StacksAndQueues;
import java.util.Iterator;

public class QueueUsingLinkedList<Item> implements Iterable<Item>{
	private Node first = null;
	private Node last = null;
	
	private class Node {
		Node next;
		Item item;
	}
	
	/* Returns BOOLEAN
	 * is this queue empty
	 * Use:
	 * queue.isEmpty();
	 * */
	public boolean isEmpty() {
		return first == null;
	}
	
	/* Returns NOTHING
	 * Add the item to the queue
	 * Use:
	 * queue.enqueue(item);
	 * */
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {oldLast.next = last;}

	}

	/* Returns Item
	 * The first item of the queue
	 * And delete it
	 * Use:
	 * queue.dequeue();
	 * */
	public Item dequeue() {
		Item answer = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return answer;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	public class QueueIterator implements Iterator<Item> {
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!this.hasNext()) {
				throw new NoNextElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	
}


