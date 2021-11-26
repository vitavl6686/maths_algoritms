/* This class provides an implementation
 * of a queue via Linked List
 * 
 * private class Node is one item of the queue
 * It contains  link to laster node and info.
 * 
 * QueueUsingLinkedList queue = new QueueUsingLinkedList();
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

public class QueueUsingLinkedList {
	private Node first = null;
	private Node last = null;
	
	private class Node {
		Node next;
		String item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String str) {
		Node oldLast = last;
		last = new Node();
		last.item = str;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {oldLast.next = last;}

	}


	public String dequeue() {
		String answer = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return answer;
	}
	
	
}


