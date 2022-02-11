package ie.vita.Assignment;

import java.util.Comparator;

public class BruteCollinearPoints {
	private Point[] buffer = new Point[4];
	private LineSegment[] segments;
	private int numberOfSegments;
	private Point min;
	private Point max;
	int N;

	public BruteCollinearPoints(Point[] points) {
		
		if (points == null) {
			throw new IllegalArgumentException();
		}
		
		N = points.length;
		segments = new LineSegment[N];
		for (int first = 0; first < N; first++) {
			if (points[first] == null) {
				throw new IllegalArgumentException();
			}
			Comparator<Point> cmp = points[first].slopeOrder();
			for (int second = first+1; second < N; second++) {
				for (int third = second+1; third < N; third++) {
					for (int forth = third+1; forth < N; forth++) {
						if(points[first].slopeTo(points[second]) == Double.NEGATIVE_INFINITY) {
							System.out.println(first+ " "+second);
							throw new IllegalArgumentException();
						}
						if ((cmp.compare(points[second], points[third]) == 0) && (cmp.compare(points[third], points[forth]) == 0)) {
							buffer[0] = points[first];
							buffer[1] = points[second];
							buffer[2] = points[third];
							buffer[3] = points[forth];
							
							min = buffer[0];
							max = buffer[0];
							for (int i = 1; i < 4; i++) {
								if (buffer[i].compareTo(min) < 0) {
									min = buffer[i];
								}
								if (buffer[i].compareTo(max) > 0) {
									max = buffer[i];
								}
							}
							
							LineSegment ls = new LineSegment(min, max);
							segments[numberOfSegments] = ls;
							numberOfSegments++;
							
						}
					}
				}
			}
		}
		

	}
		
	public int numberOfSegments() {
		return numberOfSegments;
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
