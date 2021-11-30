/* This class provides an implementation
 * of a stack via resizing array. 
 * 
 * StackUsingResizingArray<Item> stack = new StackUsingResizingArray<>();
 * */

package ie.vita.StacksAndQueues;

import java.util.Iterator;

public class StackUsingResizingArray <Item> implements Iterable<Item> {
	
	@SuppressWarnings("unchecked")
	private Item[] s = (Item[]) new Object[1];
	private int N = 0;
	
	/* Returns BOOLEAN 
	 * is this stack empty
	 * Use:
	 * stack.isEmpty();
	 *  */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/* Returns NOTHING
	 * Add an item into the stack
	 * Use:
	 * stack.push(item);
	 * */
	
	public void push(Item str) {
		if (N == s.length) {
			resize(N*2);
		}
		s[N] = str;
		N += 1;
	}
	
	/* Returns Item
	 * Returns the last element of the stack
	 * And deletes it
	 * Use:
	 * stack.pop();
	 * */
	
	public Item pop() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		if (N == s.length/4) {
			resize(s.length/2);
		}
		
		N = N - 1;
		Item item = s[N];
		s[N] = null;
		return item;
	}
	
	
	private void resize(int capacity) {
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0 ; i < N; i++) {
			copy[i] = s[i];
		}	
		s = copy;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> {
		int index = N-1;
		@Override
		public boolean hasNext() {
			return index >= 0;
		}

		@Override
		public Item next() {
			if (!this.hasNext()) {
				throw new NoNextElementException();
			}
			Item data = s[index];
			index -= 1;
			return data;
		}
		
	}
	
}
