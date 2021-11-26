/* This class provides an implementation
 * of a stack via Linked List
 * 
 * private class Node is one item of the stack
 * It contains  link to earlier node and info.
 * 
 * StackUsingLinkedList stack = new StackUsingLinkedList();
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
public class StackUsingLinkedList {
	private class Node {
		String item;
		Node next;
	}
	
	Node first = null;
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
}
