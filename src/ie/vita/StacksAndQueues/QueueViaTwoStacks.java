
package ie.vita.StacksAndQueues;

public class QueueViaTwoStacks<Item> {
	private final StackUsingLinkedList<Item> firstStack;
	private final StackUsingLinkedList<Item> secondStack;
	
	QueueViaTwoStacks() {
		firstStack = new StackUsingLinkedList<Item>();
		secondStack = new StackUsingLinkedList<Item>();
	}
	
	public void enqueue(Item item) {
		firstStack.push(item);
	}
	
	public Item dequeue() {
		if (secondStack.isEmpty()) {
			while(!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}
		}
		return secondStack.pop();
	}
	
	
	
}
