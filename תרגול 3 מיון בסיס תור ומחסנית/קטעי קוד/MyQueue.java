package S3;

import java.util.NoSuchElementException;

public class MyQueue<TypeName> {
	private TypeName[] arr;  // array to store queue elements
	private int size;      // size of the queue
	private int head;         // front points to front element in the queue
	
	// Constructor to initialize queue
	public MyQueue(int size) {
		arr = (TypeName[]) new Object[size];
		size = 0;
		head = 0;
	}
	// Utility function to add an item to the queue
	public void enQueue(TypeName element) {
		ensureCapacity();
		arr[(head + size) % arr.length] = element;
		size ++;
	}
	
	// ensures that data has the capacity to hold additional elements
	// data is reallocated in case it doesn't
	private void ensureCapacity() {
		if (size >= arr.length){			
			TypeName[] newData = (TypeName[]) new Object[arr.length*2 + 1];
			for(int i=0; i<arr.length; i++)
				newData[i] = arr[i];        
			arr = (TypeName[]) newData;
		}		
	}
	// Utility function to remove front element from the queue
	public TypeName deQueue() {
		if(isEmpty())  throw new NoSuchElementException("No elements present in Stack"); 
		TypeName ans = (TypeName)arr[head];
		size--;
		head = (head + 1) % arr.length; // Next Position
		return ans;		
	}
	
	/* Returns the FIRST element in the queue */
	public TypeName peek() {
		if(isEmpty())  throw new NoSuchElementException("No elements present in Stack"); 
		return arr[head];
	}

	/* Returns true iff the queue is empty */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/* clear the queue */
	public void clear() {
		size = 0;
		arr = (TypeName[]) new Object[arr.length];
		head = 0;
	}
	/* returns true iff the element is in the queue */
	public boolean contains(TypeName element) {
		for(int i=0; i<arr.length; i++)
			if(arr[i] == element)
				return true;
		return false;
	}
	/* Returns the size of the queue */
	public int size() { return size; }
	
	/* Returns string that represent the stack */
	public String toString()  {
		String ans = "The queue: [ <- ";
		for(int i=head; i<size; i++) {
			ans += arr[i];
			if(i != size - 1)
				ans += ", ";
		}
		return ans += "]";
	}
	
}
