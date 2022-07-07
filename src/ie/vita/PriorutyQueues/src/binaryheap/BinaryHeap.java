package binaryheap;

import java.util.Vector;

import elementary.ComparingMethods;
import elementary.NoNextElementException;

public class BinaryHeap<Item extends Comparable<Item>> {
	private Vector<Item> arr;
	private int N;


	

	public BinaryHeap() {
		arr = new Vector<Item>(10);
		arr.add(null);
		N = 1;
	}
	
	public void insert(Item item) {
		if(arr.size() > N) {
			arr.set(N, item);
		}
		else {arr.add(item);};
		swim(N);
		N++;

	}
	
	public Item delMax() {
		if (this.isEmpty()) {
			throw new NoNextElementException("Error: The heap is empty");
		}
		Item result = arr.get(1);
		arr.set(1, arr.get(N-1));
		sink(1);
		N--;
		
		return result;
	}
	
	public int size() {
		return N-1;
	}
	
	public boolean isEmpty() {
		
		return (N == 1);
	}
	
	public Item max() {
		if (this.isEmpty()) {
			throw new NoNextElementException("Error: The heap is empty");
		}
		return arr.get(1);
	}
	private void swim(int index) {
		while(index/2 > 0 && ComparingMethods.less(arr.get(index/2), arr.get(index))) {
			Item temp = arr.get(index);
			arr.set(index, arr.get((index/2)));
			arr.set(index/2, temp);
			index = index/2;
		}
		
	}
	
	private void sink(int index) {
		
		while (2*index < N) {
			int j = 2 * index;
			if (j+1 < N && ComparingMethods.less(arr.get(j), arr.get(j+1))) {
				j = j+1;
			}
			if (ComparingMethods.less(index, j)) {
				Item temp = arr.get(index);
				arr.set(index, arr.get(j));
				arr.set(j, temp);
			}
			index = j;
		}
	}
		
	

}
