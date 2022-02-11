package ie.vita.Sorting;

public class MergeSort {
	static int CUTOFF = 7;
	public static void sort (Comparable[] arr) {
		int N = arr.length;
		
		Comparable[] buffer = new Comparable[N];
		sort(arr, buffer, 0, N-1);
	}
	
	public static void sort(Comparable[] arr, Comparable[] buffer, int low, int high) {
		
		/*recursive calls are too complicated for using for small arrays. 
		 * it's much more effective to use other sorting methods  */
		if (high <= low + CUTOFF) {
			ShellSort.sort(arr);
			return;
		} 
		
		int mid = low+(high-low)/2;
		sort(arr, buffer, low, mid);
		sort(arr, buffer, mid+1, high);
		/*That means that the subarray is already sorted*/
		if(!SortingMethod.less(arr[mid+1], arr[mid])) {return;}
		merge(arr, buffer, low, mid, high);
	}
	
	public static void merge(Comparable[] arr, Comparable[] buffer, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			buffer[i] = arr[i];
		}
		

		int i = low;
		int j = mid+1;
		
		for (int k = low; k<=high; k++) {
			if (i > mid) {arr[k] = buffer[j++];}
			else if (j > high) {arr[k] = buffer[i++];}
			else if (SortingMethod.less(buffer[i], buffer[j])) {arr[k] = buffer[i++];}
			else {arr[k] = buffer[j++];}
		}
	}
	
}
