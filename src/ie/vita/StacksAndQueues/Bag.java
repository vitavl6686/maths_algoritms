/* This class provides an implementation
 * of a bag via Linked List
 * 
 * Bag is a structure for keeping items without order.
 * Use:
 * Bag<Item> bag = new Bag<>();
 *  
 * */

package ie.vita.StacksAndQueues;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	/*Returns BOOLEAN
	 * is this bag empty
	 * Use:
	 * bag.isEmpty();
	 * */
	public boolean isEmpty() {
		return (first == null);
	}

	/* Returns NOTHING
	 * Add the item to the bag
	 * Use:
	 * bag.push(item);
	 * */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item>{
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (this.hasNext() == false) {
				throw new NoNextElementException("There is no next element");
			}
			
			Item oldCurrent = current.item;
			current = current.next;
			return oldCurrent;
		}
		
	}
}


