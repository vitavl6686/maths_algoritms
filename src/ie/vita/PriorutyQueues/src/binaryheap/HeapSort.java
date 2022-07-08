package binaryheap;

import elementary.ComparingMethods;

public class HeapSort {

	public static void main(String[] args) {
		String[] arr = new String[] {"A", "D", "F", "T", "Z"};

		
		sort(arr);
		for (String a : arr) {
			System.out.println(a);
		}

	}
	
	public static void sort(Comparable[] array) {
		int N = array.length - 1; //the last element pointer
		for(int index = (N-1)/2; index >= 0; index--) {
			sink(array, index, N);
		}
		
		for (int i = N; i > 0; i--) {
			Comparable temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			i--;
			sink(array, 0, i);
		}
	}
	
	private static void sink(Comparable[] array, int index, int N) {
		while(2 * index + 1 <= N) {
			int j = 2 * index + 1;
			if (j+1 <= N && ComparingMethods.less(array[j], array[j+1])) {
				j = j + 1;
			}
			if (ComparingMethods.less(array[index], array[j])) {
				Comparable temp = array[index];
				array[index] = array[j];
				array[j] = temp;
			}
			index = j;
		}
	}

}
