/* This class provides an implementation
 * of a queue via Resizing array.
 * 
 * Use:
 * QueueUsingResizingArrays<Item> queue = new QueueUsingResizingArrays<>();
 *  
 * */
package ie.vita.StacksAndQueues;
import java.util.Iterator;

public class QueueUsingResizingArrays<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	Item[] workArray = (Item[]) new Object[1];
	int last = 0;
	int first = 0;
	
	
	
	/* Returns BOOLEAN
	 * is this queue empty
	 * Use:
	 * queue.isEmpty();
	 * */
	public boolean isEmpty() {
		return first == workArray.length | workArray[first] == null;
	}
	/* when we resize an array right after deleting the last node,
	 * first will be equal to 0
	 * */
	
	
	/* Returns NOTHING
	 * Add the item to the queue
	 * Use:
	 * queue.enqueue(item);
	 * */
	public void enqueue(Item item) {
		if (last == workArray.length) {
			resize(2 * workArray.length);
		}
		workArray[last] = item;
		last += 1;	
	}
	
	/* Returns Item
	 * The first item of the queue
	 * And delete it
	 * Use:
	 * queue.dequeue();
	 * */
	public Item dequeue() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		Item info = workArray[first];
		workArray[first] = null;
		first = first+1;

		if (first > 3 * workArray.length / 4) {
			resize(workArray.length/2);
		}
		
		return info;
	}
	
	
	private void resize(int capacity) {
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];
		int k = 0;
		for (int i = first; i < last; i++) {
			copy[k] = workArray[i];
			k++;
		}
		last = last - first;
		first = 0;	
		workArray = copy;
	}


	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		int current = first;
		@Override
		public boolean hasNext() {
			return current < last;
		}

		@Override
		public Item next() {
			if (!this.hasNext()) {
				throw new NoNextElementException();
			}
			Item info = workArray[current];
			current += 1;
			return info;
		}
		
	}
	
}
