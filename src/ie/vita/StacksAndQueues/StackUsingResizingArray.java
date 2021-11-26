/* This class provides an implementation
 * of a stack via resizing array
 * 
 * StackUsingResizingArray stack = new StackUsingResizingArray();
 * 
 * stack.push(string) adds string to the stack.
 * returns NOTHING
 * 
 * stack.pop() deletes the last item, return it.
 * Returns the last item (String)
 * 
 * stack.isEmpty() returns BOOLEAN (is this stack empty)
 * 
 *  
 * */

package ie.vita.StacksAndQueues;

public class StackUsingResizingArray {

	private String[] s = new String[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String str) {
		if (N == s.length) {
			resize(N*2);
		}
		s[N] = str;
		N += 1;
	}
	
	public String pop() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		if (N == s.length/4) {
			resize(s.length/2);
		}
		
		N = N - 1;
		String item = s[N];
		s[N] = null;
		return item;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0 ; i < N; i++) {
			copy[i] = s[i];
		}	
		s = copy;
	}
	
	

}
