package S1;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Question4 {
	
	public class TwoStacksQueue<T> {
		Stack<T> stack1;
		Stack<T> stack2;

		// Constructor to initialize queue
		public TwoStacksQueue() {
			stack1 = new Stack<T>();
			stack2 = new Stack<T>();
		}

		// Utility function to add an item to the queue
		public void enQueue(T element)  {
			stack1.add(element);
		}
		// Utility function to remove front element from the queue
		public T deQueue() {
			if(!stack2.isEmpty()) return stack2.pop();
			else {
				if(stack1.isEmpty()) throw new NoSuchElementException("No elements present in Queue");
				while(!stack1.isEmpty())
					stack2.push(stack1.pop());

				return stack2.pop();	
			}
		}

		// Utility function to return front element in the queue
		public T peek() { 
			if(!stack2.isEmpty()) return stack2.peek();
			else {
				if(stack1.isEmpty()) throw new NoSuchElementException("No elements present in Queue");
				while(!stack1.isEmpty())
					stack2.push(stack1.pop());
				return stack2.peek();	
			}

		}
		public int size() { return stack1.size() + stack2.size(); }
		// Utility function to check if the queue is empty or not
		public boolean isEmpty() { return stack1.isEmpty() && stack2.isEmpty(); }
	}
	public static void main(String[] args) {
		// create a queue 
		Question4.TwoStacksQueue<Integer> q = new Question4().new TwoStacksQueue<Integer>();

		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.println("Front element is: " + q.peek());
		System.out.println(q.deQueue());
		System.out.println("Front element is: " + q.peek());

		System.out.println("Queue size is " + q.size());

		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());


		if (q.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");
	}
}
