package S3;


public class MyQueueTesting {

	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>(3);
		q.enQueue("hello world");
		q.enQueue("a");
		q.enQueue("b");
		System.out.println(q.size()); // 3
		q.enQueue("c");
		q.enQueue("d");
		System.out.println(q.size()); // 5
		System.out.println(q.isEmpty()); // False
		System.out.println(q.toString());
		System.out.println(q.deQueue());
		System.out.println(q.toString());
	}
}
