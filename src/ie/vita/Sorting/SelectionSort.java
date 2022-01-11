/* This class implements selection sorting
 * to use:
 * SelectionSort.sort(Comparable arr[]);
 * 
 * arr should be Comparable
 * */

package ie.vita.Sorting;
public class SelectionSort {
	
	public static void sort(Comparable[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int indMin = i;
			for (int j = i+1; j < N; j++) {
				if (less(arr[j], arr[indMin])) {
					indMin = j;
				}
			}
			exchange(arr, i, indMin);
		} 
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exchange(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
