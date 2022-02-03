package ie.vita.Assignment;

import java.util.Arrays;

public class BruteCollinearPoints {
	private int[] buffer = new int[4];
	private LineSegment[] segments;
	private int numberOfSegment;
	public BruteCollinearPoints(Point[] points) {
		segments = new LineSegment[points.length/4];
		numberOfSegment = 0;

		int buf_ind = 0;
		for (int i = 0; i < points.length; i ++) {
			if (points[i] != null) {
				buffer[0] = i;
				
				for (int m = 1; m < 4; m++) {
					buffer[m] = -1;
				}
				

				for (int k = i+1; k<points.length; k++) {					
					if (points[k] != null) {
						if(points[i].slopeTo(points[k]) == 0) {
							buffer[buf_ind++] = k;
							if (buf_ind > 3) {break;}
						}
					}
				}
				workWithArray(points, buf_ind);
			}
				
		}
	}
	
	private void workWithArray(Point[] points, int ind) {
		if (ind > 3) {
			
			int max = 0;
			for (int i = 1; i < 4; i++) {
				if (points[buffer[i]].compareTo(points[buffer[max]]) == 1 ) {
					max = i;
				}
			}
			
			int min = 0;
			for (int i = 1; i < 4; i++) {
				if (points[buffer[i]].compareTo(points[buffer[max]]) == -1 ) {
					min = i;
				}
			}
			
			LineSegment segment = new LineSegment(points[buffer[min]],points[buffer[max]]);
			segments[this.numberOfSegment] = segment;
			this.numberOfSegment += 1;

		}
		
		for (int i = 0; i < buffer.length; i++) {
			points[i] = null;
		}
		
	}
	
	public int numberOfSegments() {
		return this.numberOfSegment;
	}
	
	
}
