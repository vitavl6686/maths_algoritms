package binaryheap;

import java.util.Vector;

import elementary.ComparingMethods;

public class BinaryHeap<Item extends Comparable<Item>> {
	public Vector<Item> arr;
	private int N;

	public static void main(String[] args) {
		BinaryHeap<String> bh = new BinaryHeap<>();
		bh.insert("A");
		bh.insert("C");
		
		
		
		for (String array : bh.arr) {
		    System.out.println(array);
		}
		
	}
	

	public BinaryHeap() {
		arr = new Vector<Item>(10);
		N = 0;
		
		
	}
	
	public void insert(Item item) {
		arr.add(item);
		swim(N);
		N++;
		
	}
	
	private void swim(int index) {
		while(ComparingMethods.less(arr.get((index-1)/2), arr.get(index)) && (index-1)/2 >= 0) {
			Item temp = arr.get(index);
			arr.set(index, arr.get((index-1/2)));
			arr.set((index-1)/2, temp);
			index = (index-1)/2;
		}
	}

}
