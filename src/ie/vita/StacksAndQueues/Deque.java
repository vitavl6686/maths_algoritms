/* Implementation of a deque with methods:
 * isEmpty(); size(); addFirst(); addLast(); removeFirst(); 
 * removeLast();
 * Iterable class. Generic.
 * 
 * Use:
 * Deque<Item> deque = new Deque<>();
 * */

package ie.vita.StacksAndQueues;

import java.util.Iterator;

public class Deque <Item> implements Iterable<Item> {
	private Node last = null;
	private Node first = null;
	private Integer size = 0;
	
	private class Node {
		Item info;
		Node next;
		Node previous;
	}
	
	public static void main(String[] args) {
		
	}
	
	/* Returns BOOLEAN
	 * is this deque empty
	 * Use:
	 * deque.isEmpty();
	 * */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/* Returns Integer
	 * size of this deque
	 * Use:
	 * deque.size();
	 * */
	public Integer size() {
		return size;
	}
	
	/* Returns NOTHING
	 * Add element into the first position of the deque
	 * Use:
	 * deque.addFirst(element);
	 * */
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		Node newFirst = new Node();
		newFirst.info = item;
		newFirst.previous = null;
		newFirst.next = first;
		if (first != null) {
			first.previous = newFirst;
		}
		first = newFirst;
		if (last == null) {last = first;};
		size += 1;
	}
	
	/* Returns NOTHING
	 * Add element into the last position of the deque
	 * Use:
	 * deque.addLast(element);
	 * */
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		Node newLast = new Node();
		newLast.info = item;
		newLast.previous = last;
		newLast.next = null;
		if (last != null) {
		last.next = newLast;
		}
		last = newLast;
		if (first == null) {
			first = last;
		}
		size += 1;
	}
	
	
	/* Returns Integer 
	 * the first element of the stack
	 * And removes it
	 * Use:
	 * deque.removeFirst();
	 * */
	public Item removeFirst() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		Item infoItem = first.info;
		if (first != last) {
		first = first.next;
		first.previous = null;
		}
		else {
			first = null;
			last = null;
		}
		size -= 1;
		return infoItem;
	}
	

	
	/* Returns Integer 
	 * the last element of the stack
	 * And removes it
	 * Use:
	 * deque.removeLast();
	 * */
	public Item removeLast() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		
		Item infoItem = last.info;
		if (last != first) {
		last = last.previous;
		last.next = null;
		}
		else {
			last = null;
			first = null;
		}
		size -= 1;
		return infoItem;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!this.hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Item item = current.info;
			current = current.next;
			return item ;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
