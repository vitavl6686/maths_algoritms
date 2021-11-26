/* This class provides an implementation
 * of a queue via Resizing array.
 * 
 * QueueUsingResizingArray queue = new QueueUsingResizingArray();
 * 
 * queue.inqueue(string) adds string to the queue.
 * returns NOTHING
 * 
 * queue.dequeue() delete the first item, return it.
 * Returns the first item (String)
 * 
 * queue.isEmpty() returns BOOLEAN (is this queue empty)
 * 
 *  
 * */
package ie.vita.StacksAndQueues;

public class QueueUsingResizingArray {
	String[] workArray = new String[1];
	int last = 0;
	int first = 0;
	
	
	/* when we resize an array right after deleting the last node,
	 * first will be equal to 0
	 * */
	public boolean isEmpty() {
		return first == workArray.length | workArray[first] == null;
	}
	
	
	public void inqueue(String str) {
		
		if (last == workArray.length) {
			resize(2 * workArray.length);
		}
		workArray[last] = str;
		last += 1;	
	}
	
	
	public String dequeue() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		String info = workArray[first];
		workArray[first] = null;
		first = first+1;

		if (first > 3 * workArray.length / 4) {
			resize(workArray.length/2);
		}
		
		return info;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		int k = 0;
		for (int i = first; i < last; i++) {
			copy[k] = workArray[i];
			k++;
		}
		last = last - first;
		first = 0;	
		workArray = copy;
	}
	
}
