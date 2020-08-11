package S4;
public class Node {
	int data;
	Node right;
	Node left;
	public int num;
	public Node(int data)
	{
		this.data = data;
		left = right = null;
		num = 1;
	}
}
