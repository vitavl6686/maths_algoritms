package ie.vita.Sorting;

public class ShellSort {

	
	public static void sort(Comparable[] arr) {
		int N = arr.length;
		int step = N/2;
		
		while(step >= 1) {
			for (int i = step; i < N; i = i+1) {
				for (int j = i; j >= step; j -= step) {
					if (SortingMethod.less(arr[j], arr[j - step]) ) {
						SortingMethod.exchange(arr, j, j - step);
					}
					else {break;}
				}
			}
			step = step/2;
		}
	}
	
}
