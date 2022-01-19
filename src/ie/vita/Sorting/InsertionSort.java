package ie.vita.Sorting;

public class InsertionSort {
	
	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; i > 0; j--) {

				if (SortingMethod.less(arr[j], arr[j-1])) {
					SortingMethod.exchange(arr, j, j-1);
				}
				else {break;}
			}
		}
	}
}
