package S5;

import S4.BST;

public class IsBalanced {
	
	public static boolean isBalanced(Node root) {
		if(root == null)
			return true;
		else
			return ( 
					isBalanced(root.right) &&
					isBalanced(root.left) &&
					(Math.abs(height(root.right) - height(root.left)) <= 1)
					);
	}

	public static int height(Node root) {
		if(root == null) 
			return -1;
		else
			return Math.max(height(root.left),height(root.right)) + 1;
	}
}
