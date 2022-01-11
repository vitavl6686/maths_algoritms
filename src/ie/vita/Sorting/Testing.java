package ie.vita.Sorting;

public class Testing {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {0, 8, 6, 4, 12, 1, 2};
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		SelectionSort.sort(arr);
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
