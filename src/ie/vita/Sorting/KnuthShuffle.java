package ie.vita.Sorting;

import java.util.Random;

public class KnuthShuffle {

	public static void shuffle(Object[] arr) {
		int N = arr.length;
		Random rand = new Random();
		Object temp = null;
		int j = 0;
		for(int i = 1; i < N; i++) {
			j = rand.nextInt(i+1);
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
