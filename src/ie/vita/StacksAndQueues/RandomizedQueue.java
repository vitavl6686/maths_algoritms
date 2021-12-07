/* This class implements RandomizedQueue
 * It's a regular queue, but a dequeue operation returns
 * and removed a random element from the queue.
 * Generic, Iterable.
 * Use:
 * 
 * RandomizedQueue<Item> rq = new RandomizedQueue<>();
 * Methods:
 * isEmpty() -- returns is the queue empty
 * size() -- returns the size of the queue
 * enqueue(item) -- adds item to the queue
 * dequeue() -- returns random item and deletes it
 * sample() -- returns random item without deleting
 * */

package ie.vita.StacksAndQueues;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
	Random randomizer;
	@SuppressWarnings("unchecked")
	Item[] mainArray = (Item[]) new Object[1];
	private int current = 0;
	
	public RandomizedQueue() {
		Date date = new Date();
		randomizer = new Random(date.getTime());
	}
	
	/* Returns BOOLEAN
	 * is this queue empty
	 * Use:
	 * rq.isEmpty();
	 * */
	public boolean isEmpty() {
		return current == 0;
	}
	
	/* Returns NOTHING
	 * Add element to the queue
	 * Use:
	 * rq.enqueue(element);
	 * */
	public void enqueue(Item item) {
		if(item == null) {
			throw new IllegalArgumentException();
		}
		
		if (current == mainArray.length) {
			resize(current * 2);
		}
		mainArray[current] = item;
		current += 1;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] newArray = (Item[]) new Object[capacity];
		for(int i = 0; i < mainArray.length; i++) {
			newArray[i] = mainArray[i];
		}	
		mainArray = newArray;
	}
	
	/* Returns Integer
	 * the number of elements in the queue
	 * Use:
	 * rq.size();
	 * */
	public int size() {
		return current;
	}
	
	/* Returns Item
	 * Choose random element of the queue
	 * Return it
	 * Delete it from the queue
	 * Use:
	 * rq.dequeue();
	 * */
	public Item dequeue() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		int num = randomizer.nextInt(current);
		Item item = mainArray[num];
		for (int i = num; i < current-1; i++) {
			mainArray[i] = mainArray[i+1];
		}
		mainArray[current-1] = null;
		current = current - 1;
		return item;
	}
	
	/* Returns Item
	 * Choose random element of the queue
	 * Return it
	 * Use:
	 * rq.sample();
	 * */
	public Item sample() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		int num = randomizer.nextInt(current);
		return mainArray[num];
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		int i = 0;
		Integer[] arr;
		QueueIterator() {
			arr = new Integer[current];
			for(Integer k = 0; k<current; k++) {
				arr[k] = k;
			}
			Collections.shuffle(Arrays.asList(arr));
			
		}
		@Override
		public boolean hasNext() {
			return i < current;
		}

		@Override
		public Item next() {
			if (!this.hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Item item = mainArray[arr[i]];
			i += 1;
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	
	
}
