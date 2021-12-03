/* This class provides an implementation
 * of a stack via Linked List (generic)
 * 
 * Use:
 * StackUsingLinkedList<Item> stack = new StackUsinglinkedList<>()
 * 
 */

package ie.vita.StacksAndQueues;
import java.util.Iterator;


public class StackUsingLinkedList<Item> implements Iterable<Item> {
	Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	/* Returns BOOLEAN
	 * is this stack empty
	 * Use:
	 * stack.isEmpty();
	 * */
	public boolean isEmpty() {
		return (first == null);
	}

	/* Returns Item
	 * Returns the last element of the stack
	 * And removes it
	 * Use:
	 * stack.pop();
	 * */
	public Item pop() {
		if(this.isEmpty()) {
			throw new NoNextElementException();
		}
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	/* Returns NOTHING
	 * Add element to the stack
	 * Use:
	 * stack.push(element);
	 * */
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
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
