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
				if (SortingMethod.less(arr[j], arr[indMin])) {
					indMin = j;
				}
			}
			SortingMethod.exchange(arr, i, indMin);
		} 
	}
	
}
