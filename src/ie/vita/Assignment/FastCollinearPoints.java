package ie.vita.Assignment;

import java.util.Arrays;

public class FastCollinearPoints {
	
	private Point[] buffer;
	private LineSegment[] segments;
	private int numberOfSegments;

	private  Point[][] slopes;
	private Point[] counter;
	int N;
	private Point[] array;
	
	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}
		
		array = points;
		N = array.length;
		segments = new LineSegment[N]; //array of line segments
		slopes = new Point[N][2]; //array of slopes for avoiding repetitive segments
		
		
		numberOfSegments = 0;
		buffer = new Point[N]; //here we'll be working with slopes
		counter = new Point[N];
		

		for (int index = 0; index < N-1; index++) {
			if (array[index] == null) {
				throw new IllegalArgumentException();
			}
			
			for (int k = index+1; k < N; k++) {
				buffer[k] = array[k];
			}

			workWithArray(index);
		}
	}
	
	
	private void workWithArray(int index) {
		Point[] localBuffer = new Point[N]; //additional array for sorting. TODO: remove this array (overflow)

		sort(buffer,localBuffer,index+1, N-1, index);
		

		int number;
		for (int i = index+1; i < N; i++) {
			if (buffer[i].slopeTo(array[index]) == Double.NEGATIVE_INFINITY) {
				throw new IllegalArgumentException();
			}
			number = 0;
			
			
			int low = i;

			int k = low;
			int high = low;
			
			while (k < N-1 && array[index].slopeTo(buffer[k+1]) == array[index].slopeTo(buffer[k])) {
				number += 1;
				high++;
				k++;
				if (k == N-1) {break;}
			}

			if (number >= 2) {
				counter[0] = array[index];
				for(int j = 1; j < 2+number; j++) {
					counter[j] = buffer[low];
					low++;
				}
				
				Point min = counter[0];
				Point max = counter[0];

				for (int n = 1; n < 2+number; n++) {
					if (counter[n].compareTo(min) < 0) {
						min = counter[n];
					}
					if (counter[n].compareTo(max) > 0) {
						max = counter[n];
					}
				}
				
				
				if (finalCheck(min, max)) {
				LineSegment ls = new LineSegment(min, max);
				slopes[numberOfSegments][0] = min;
				slopes[numberOfSegments][1] = max;
				segments[numberOfSegments] = ls;
				numberOfSegments++;
				}
				i = high+1;
			}
		}
	}
	
	
	private boolean finalCheck(Point min, Point max) {
		
		for (int i = 0; i < numberOfSegments; i++) {
			if ((slopes[i][0] == min) && ((slopes[i][1] == max) || (min.slopeTo(max)== slopes[i][0].slopeTo(slopes[i][1])))) {
				return false;
			}
		}
		return true;
	}
	public int numberOfSegments() {
		return this.numberOfSegments;
	}
	
	

	
	private void sort(Point[] arr, Point[] buffer, int low, int high, int slope) {
		if (high <= low) {return;}
		int mid = low+(high-low)/2;
		sort(arr, buffer, low, mid, slope);
		sort(arr, buffer, mid+1, high, slope);
		
		merge(arr, buffer, low, mid, high, slope);
	}
	
	private void merge(Point[] arr, Point[] buffer, int low, int mid, int high, int slope) {

		for (int i = low; i <= high; i++) {
			buffer[i] = arr[i];
		}
		
		

		int i = low;
		int j = mid+1;
		
		for (int k = low; k<=high; k++) {
			if (i > mid) {arr[k] = buffer[j++];}
			else if (j > high) {arr[k] = buffer[i++];}
			else {
				if (array[slope].slopeTo(buffer[i]) < array[slope].slopeTo(buffer[j])) {
				arr[k] = buffer[i++];}
				else {arr[k] = buffer[j++];}
			}
		}
		
	}
	
	public LineSegment[] segments() {
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (segments[i] == null) {break;}
			count++;
		}
		LineSegment[] answer = new LineSegment[count];
		for (int i = 0; i<count; i++) {
			answer[i] = segments[i];
		}
		return answer;
	}
	
	}

