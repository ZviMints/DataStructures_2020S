package S1;

import java.util.Stack;

public class Question5 {

	public static void main(String[] args) {
		String valid = "{[{}{}]}[()]";
		String invalid = "{()}[)";
		
		System.out.println(Question5(valid));
		System.out.println(Question5(invalid));
	}

	// Function to check if given expression is balanced or not
	private static boolean Question5(String s) {
		// take a empty stack of characters
		Stack<Character> st = new Stack<Character>();
		
		// traverse the input expression
		for(int i=0, n = s.length(); i<n ; i++) {
			
			char curr = s.charAt(i);
			
			// if current char in the expression is a opening brace,
			// push it to the stack
			if(curr == '(' || curr == '{' || curr == '[' ) {
				st.push(curr);
			}			
			else { // Its } or ) or ]
				
				// return false if mismatch is found (i.e. if stack is
				// empty, the number of opening braces is less than number
				// of closing brace, so expression cannot be balanced)
				if(st.isEmpty())
					return false;
				
				// pop character from the stack
				char top = st.pop();
				if( top == '(' && curr != ')' ||
					top == '[' && curr != ']' ||
					top == '{' && curr != '}' )
					return false;			
			}
		}
		// expression is balanced only if stack is empty at this point
		return st.isEmpty();
	}
}
