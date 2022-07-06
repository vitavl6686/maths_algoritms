package elementary;
/* Priority queue implementation via Unordered Linked List. 
 * Deprecated because of the inefficiency.
 * 
 * USE:
 * UnorderedLinkedList<Item> oll = new UnOrderedLinkedList<>(); where Item is Comparable.
 * 
 * METHODS:
 * oll.insert(Item item) --> void. Add a value item to the Priority Queue
 * oll.size() --> int. Returns the number of elements of the queue
 * oll.delMax() --> Item. Returns the max element of the queue and deletes it.
 * oll.max() --> Item. Returns the max element of the queue.
 * oll.isEmpty() --> boolean. Returns true if the queue is empty and false otherwise.
 * 
 * COMPLEXITY:
 * .size(), .insert(), isEmpty() --> O(1)
 * .delMax(), max() --> O(N)
 * 
 * */
public class UnorderedLinkedList <Item extends Comparable<Item>> {

	private Node last = null;
	private int size = 0;
	
	private final class Node {
		Item item;
		Node next;
	}
	
	public UnorderedLinkedList() {
		
	}
	
	public void insert(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = oldLast;
		size += 1;
	}
	

	
	public boolean isEmpty() {
		return last == null;
	}
	
	public Item delMax() {
		if (isEmpty() == false){
			Node element = last;
			Node link = last;
			Item max = last.item;
			Node maxLink = link;
			while (element != null) {
				if (ComparingMethods.less(max, element.item)) {
					max = element.item;
					maxLink = link;
				}
				link = element;
				element = element.next;	
			}
			Node maxEl = maxLink.next;
			if (maxEl != null){
			link.next = maxEl.next;
			}
			else {last = null;}
			size -= 1;
			
		return max;
		}
		
		else {
			throw new NoNextElementException("The queue is empty");
		}
	}
	
	public Item max() {
		if (isEmpty() == false){
			Node element = last;
			Item max = last.item;
			while (element != null) {
				if (ComparingMethods.less(max, element.item)) {
					max = element.item;
				}
				element = element.next;	
			}
			return max;
		}
		return null;
	}
	
	
	
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {}
	

}
