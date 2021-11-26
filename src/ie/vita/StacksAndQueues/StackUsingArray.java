
package ie.vita.StacksAndQueues;

public class StackUsingArray {
	private int N;
	private String[] s; 

	StackUsingArray(int capacity) {
		s = new String[capacity];
		N = 0;
	}
	
	
	public boolean isEmpty() {
		return (N  == 0);
	}
	
	public void push(String item) {
		s[N] = item;
		N = N+1;
	}
	
	public String pop() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		N = N-1;
		String item = s[N];
		s[N] = null; //to avoid loitering
		return item;
	}
	
}
