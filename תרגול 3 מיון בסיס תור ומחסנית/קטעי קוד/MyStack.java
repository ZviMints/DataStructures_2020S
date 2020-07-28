package S3;

import java.util.NoSuchElementException;

public class MyStack {
	private int[] arr;
	private int size = 0;

	// Constructor
	public MyStack(int capacity) {
		arr = new int[capacity];
	}

	// Adds new element to the Stack
	// Input: element of type T
	public void push(int element) {
		ensureCapacity();
		

		arr[size] = element;
		size++;
	}

	// ensures that data has the capacity to hold additional elements
	// data is reallocated in case its doesn't
	public void ensureCapacity() {
		if(size == arr.length) {
			int[] newArr = new int[size*2 + 1];
			for(int i=0; i<size; i++)
				newArr[i] = arr[i];
			arr = newArr;
		}
	}


	// Remove the TOP element 
	// Returns the first element in the stack */
	public int pop() {
		if(size == 0) throw new NoSuchElementException("No elements presenint in Stack");
		else return arr[--size];
	}

	/* Returns the TOP element in the stack */
	public int top() {
		if(size == 0) throw new NoSuchElementException("No elements presenint in Stack");
		return arr[size-1]; 
	}

	/* Returns true iff the stack is empty */
	public boolean isEmpty() { return size == 0; }

	/* clear the stack */
	public void clear() { size = 0; }

	/* returns true iff the element is in the stack */
	public boolean search(int element) { 
		for(int i=0; i<size; i++) {
			if(arr[i] == element)
				return true;
		}
		return false;
	}

	/* Returns the size of the stack */
	public int size() { return size; }
	
	/* Returns string that represent the stack */
	public String toString()  {
		String ans = "Stack: [";
		for(int i=0; i<size; i++) {
			ans += arr[i];
			if(i != size - 1)
				ans += ", ";
		}
		return ans += " -> ]";
	}
}

