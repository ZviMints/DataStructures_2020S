package S3;

import S1.MyQueue;

public class MyStackTesting {

	public static void main(String[] args) {
		MyStack s = new MyStack(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.size()); // 5
		System.out.println(s.top()); // 5
		System.out.println(s.pop()); // 5
		System.out.println(s.top()); // 4
		System.out.println(s.toString()); // Stack: [1, 2, 3, 4 ->]
		System.out.println(s.pop());
		System.out.println(s.toString()); // Stack: [1, 2, 3 -> ]
		System.out.println(s.isEmpty()); // False
		s.clear();
		System.out.println(s.isEmpty()); // True
		s.push(1);
		System.out.println(s.top()); // 1
		System.out.println(s.toString()); // Stack: [1 ->]
	}
}
