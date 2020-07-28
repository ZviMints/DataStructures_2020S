package S3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question6_palindrom {

	public static void main(String[] args) {
		System.out.println(palindrom("abcdcba")); // true
		System.out.println(palindrom("abbbb")); // false 
		System.out.println(palindrom("123321")); // true
		System.out.println(palindrom("12321")); // true
		System.out.println(palindrom("ffff")); // true
		System.out.println(palindrom("123431")); // false
	}
	public static boolean palindrom(String str) {
		
		Stack<Character> s = new Stack<Character>();
		Queue<Character> q = new LinkedList<Character>();	
		
		for(int i=0; i<str.length(); i++) {
			s.push(str.charAt(i));
			q.add(str.charAt(i));
		}
		
		while(!s.isEmpty()) {
			if(!s.pop().equals(q.poll()) ) return false;
		}
		return true;
		
		
	}
}
