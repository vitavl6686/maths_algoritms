/*This class implements stack with standart operations 
 * pop(), push(Integer int), isEmpty();
 * There is also an operation ReturnMax(), which returns the maximum
 * of all elements of the stack.
 * 
 * Use:
 * StackWithMax stack = new StackWithMax();
 * */


package ie.vita.StacksAndQueues;

public class StackWithMax {
	private final StackUsingLinkedList<Integer> mainStack;
	private final StackUsingLinkedList<Integer> maxStack;
	private Integer lastMax = null;
	
	
	StackWithMax() {
		mainStack = new StackUsingLinkedList<Integer>();
		maxStack = new StackUsingLinkedList<Integer>();
	}
	
	/* Returns BOOLEAN
	 * is this stack empty
	 * Use:
	 * stack.isEmpty();
	 * */
	public boolean isEmpty() {
		return lastMax == null;
	}
	
	/* Returns NOTHING
	 * Add element to the stack
	 * Use:
	 * stack.push(element);
	 * */
	
	
	public void push(Integer number) {
		if(lastMax == null) {
			lastMax = number;
		}
		
		else {
			if (number > lastMax) {
				lastMax = number;
			}
		}

		maxStack.push(lastMax);
		mainStack.push(number);
	}
	
	/* Returns Integer
	 * Returns the last element of the stack
	 * And removes it
	 * Use:
	 * stack.pop();
	 * */
	public Integer pop() {
		maxStack.pop();
		lastMax = maxStack.pop();
		maxStack.push(lastMax);
		return mainStack.pop();
	}
	
	/*Returns Integer
	 * max element of the stack
	 * Use:
	 * stack.returnMaximum();
	 * */
	public Integer returnMaximum() {
		return lastMax;
	}
}


