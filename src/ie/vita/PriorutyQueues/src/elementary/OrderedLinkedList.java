package elementary;

/* Priority queue implementation via Ordered Linked List. 
 * Deprecated because of the inefficiency.
 * 
 * USE:
 * OrderedLinkedList<Item> oll = new OrderedLinkedList<>(); where Item is Comparable.
 * 
 * METHODS:
 * oll.insert(Item item) --> void. Add a value item to the Priority Queue
 * oll.size() --> int. Returns the number of elements of the queue
 * oll.delMax() --> Item. Returns the max element of the queue and deletes it.
 * oll.max() --> Item. Returns the max element of the queue.
 * oll.isEmpty() --> boolean. Returns true if the queue is empty and false otherwise.
 * 
 * COMPLEXITY:
 * .size(), .isEmpty(), .delMax(), .max() --> O(1)
 * .insert() --> O(N)
 * 
 * */
public class OrderedLinkedList <Item extends Comparable<Item>> {

	private Node max = null;
	private int size = 0;
	
	private final class Node {
		Item item;
		Node next;
	}
	
	public void insert(Item item) {
		if (!isEmpty()) {
			Node element = max;
			Node link = max;
			while (ComparingMethods.less(item, element.item) && element != null) {
				link = element;
				element = element.next;
			}
			
			Node newest = new Node();
			newest.item = item;
			newest.next = element;
			if (link == element) {max = newest;}
			else{link.next = newest;}
			
		}
		
		else {
			Node newest = new Node();
			newest.item = item;
			newest.next = null;
			max = newest;
		}
		
		size += 1;
	}
	
	public int size() {
		return size;
	}
	
	public Item delMax() {
		Item value = max.item;
		max = max.next;
		size -= 1;
		return value;
	}
	
	public Item max() {
		return max.item;
	}
	
	public boolean isEmpty() {
		return max == null;
	}
	
	public static void main(String[] args) {
		String a = "A";
		OrderedLinkedList<String> oll = new OrderedLinkedList<>();
		oll.insert(a);
		a = "B";
		System.out.println(oll.delMax());
	}


	
}
