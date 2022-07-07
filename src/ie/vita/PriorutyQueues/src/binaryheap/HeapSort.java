package binaryheap;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sort(Comparable[] array) {
		int N = array.length - 1; //the last element pointer
		for(int index = (N-1)/2; index >= 0; index--) {
			sink(array, index, N);
		} 
	}
	
	private static void sink() {
		
	}

}
