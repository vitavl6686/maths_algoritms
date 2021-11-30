
package ie.vita.StacksAndQueues;

public class StackUsingArray<Item> {
	private int N;
	private Item[] s; 

	@SuppressWarnings("unchecked")
	StackUsingArray(int capacity) {
		s = (Item[]) new Object[capacity];
		N = 0;
	}
	
	
	public boolean isEmpty() {
		return (N  == 0);
	}
	
	public void push(Item item) {
		s[N] = item;
		N = N+1;
	}
	
	public Item pop() throws EmptyArrayException {
		if (isEmpty()) {
			throw new EmptyArrayException();
		}
		
		N = N-1;
		Item item = s[N];
		s[N] = null; //to avoid loitering
		return item;
	}
	
}
