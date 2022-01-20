package ie.vita.Sorting;

public class BubbleSort {

	public static void sort(Comparable[] arr) {
		int N = arr.length;
		boolean flag = true;
		
		for (int j = N-2; j > 0 && flag == true; j-- ) {
			flag = false;
			for  (int i = 0; i < N-1; i++) {
				if (SortingMethod.less(arr[i+1], arr[i])) {
					SortingMethod.exchange(arr, i, i+1);
					flag = true;
				}
			}
		}
	}
}
