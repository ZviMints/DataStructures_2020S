package S3;

import S1.MyQueue;

public class Question2_SortStack {

	public static void main(String[] args) {	
		MyStack input = new MyStack(0);
		int arr[] = {-1,5,1,5,7,9,1,2,5,6,12,0,-5,1,2,5,6,1,171};
		for(int i=0, n=arr.length; i<n; i++)
			input.push(arr[i]);
		System.out.println(input.toString());
		MyStack s = sortStack(input);
		System.out.println(s.toString());
	}
	// https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
	// This function return the sorted stack 
	public static MyStack sortStack(MyStack input) {
		MyStack tempStack = new MyStack(input.size());
		
		
		
		while(!input.isEmpty()) // While There elements to sort
		{
			// pop out the first element of the <input>
			int tempValue = input.pop();

			// while temporary stack is not empty and 
			// top of stack is greater than tempValue 
			while(!tempStack.isEmpty() && tempStack.top() > tempValue) {
				// pop from temporary stack and  
				// push it to the input stack 
				input.push(tempStack.pop());
			}
			
			// push temp in tempory of stack 
			tempStack.push(tempValue); 

		}
		return tempStack;


	}

}
