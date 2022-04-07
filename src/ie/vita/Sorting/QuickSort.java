package ie.vita.Sorting;

import java.util.Arrays;

public class QuickSort {
		
	public static void sort(Comparable[] arr) {
		KnuthShuffle.shuffle(arr);
		int low = 0; 
		int high = arr.length-1;
		int middle = partition(arr, low, high);
		sort(arr, low, middle-1);
		sort(arr, middle+1, high);
	}
	
	private static void sort(Comparable[] arr, int low, int high) {
		if (low >= high) {return;}
		int middle = partition(arr, low, high);
		sort(arr, low, middle-1);
		sort(arr, middle+1, high);
	}
	
	private static int partition(Comparable[] arr, int low, int high) {
		int i = low+1;
		int j = high;
		while(i < j) {
			while (SortingMethod.less(arr[i], arr[low]) && i <= high) {
				i++;
			}
			while (SortingMethod.less(arr[low], arr[j]) && j >= low) {
				j--;
			}
			if (i < j) {
			Comparable temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			}
		}
		if (SortingMethod.less(arr[j], arr[low])) {
		Comparable temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		}
		return j;
	}
	
	public static void main(String[] str) {
		String[] arr = new String[] {"A","A", "A", "B", "D"};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
