package S3;

import java.util.Arrays;
import java.util.Stack;

import S1.MyQueue;

public class Question3_DoublePoint {

	public static void main(String[] args) {	
		double input = 246.642;
		boolean ans = Question3(input);
		System.out.println(ans);
	}

	private static boolean Question3(double input) {
		Stack<Character> s = new Stack<Character>();
		String inputString = input + "";
		int index = inputString.indexOf('.') + 1;
		for(int i=0; inputString.charAt(i) != '.' ; i++)
			s.push(inputString.charAt(i));
		
		for(int i=index; i<inputString.length(); i++)
			if(s.pop() != inputString.charAt(i)) return false;
		
		return s.isEmpty();
	}
}
