package S5;

// Based on WilliamFiset
// Zvi Mints 

public class AVLTree {
	
	// The root node of the AVL Tree
	Node root;
	private int count = 0; // Number of nodes inside the tree
	// -------------------------------------
	// The height of a rooted tree is the number of edges
	// between the tree's root and its furthest leaf
	public int height() {
		if(root == null) return -1;
		return root.height;
	}
	// -------------------------------------
	// returns the number of nodes in the tree
	public int size() { return count; }
	// -------------------------------------

	// returns true iff the tree is empty
	public boolean isEmpty() { return size() == 0; }
	// -------------------------------------

	// Return true iff the node with value "value" exists in the tree
	public boolean contains(int value) {
		return contains(root, value);
	}
	private boolean contains(Node current, int value) {
		// Base case
		if(current == null) return false;

		int cmp = value - current.value;
		// Dig into the right subtree
		if(cmp > 0) return contains(current.right, value);

		// Dig into the left subtree
		if(cmp < 0) return contains(current.left,value);

		// Found value in the tree
		return true;
	}
	// -------------------------------------
	// Insert a value to the AVL tree. 
	// O(log(n))
	public boolean insert(int value) {
		if(!contains(root,value)) {
			root = insert(root,value);
			count++;
		}
		return false;
	}
	private Node insert(Node current, int value) {
		// Base case
		if( current == null ) return new Node(value);

		// Compare current value to the value in the node
		int cmp = value - current.value;

		// Insert the node in right subtree
		if(cmp > 0)
			current.right = insert(current.right, value);
		// Insert the node in left subtree
		else
			current.left = insert(current.left,value);

		// ****** 2 Lines to add for the AVL Trees ****** //
		// Update balance factor and height values
		update(current);

		// Re-balance tree
		return balance(current);
		// ********************************************* //			
	}
	// Update a node's height and Balance factor
	private void update(Node node) {

		int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
		int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

		// Update this node's height
		node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
		// Update this node balance factor
		node.bf = rightNodeHeight - leftNodeHeight;
	}

	// Re-balance a node if its balance factor is +-2
	private Node balance(Node node) {
		// left-heavy subtree
		if( node.bf == -2) { // L
			// Left-left case
			if(node.left.bf <= 0) // LL
				return leftLeftCase(node);
			else // Left-Right case // LR
				return leftRightCase(node);
		}
		else if( node.bf == +2) { // R
			// right-heavy subtree
			if(node.right.bf >= 0) // RR
				return rightRightCase(node);
			else // Right-Left case // RL
				return rightLeftCase(node);
		}
		// BF is in {-1,0,1}
		return node;
	}
	private Node leftLeftCase(Node node) {
		return rightRotation(node);
	}

	private Node leftRightCase(Node node) {
		node.left = leftRotation(node.left);
		return leftLeftCase(node);
	}

	private Node rightRightCase(Node node) {
		return leftRotation(node);
	}

	private Node rightLeftCase(Node node) {
		node.right = rightRotation(node.right);
		return rightRightCase(node);
	}

	private Node leftRotation(Node node) {
		// node is z
		Node newParent = node.right; 
		// newParent is y
		node.right = newParent.left; 
		// z.right is now T2
		newParent.left = node;
		// y.left is now z

		update(node);
		update(newParent);
		// This order the important!

		return newParent;
	}
	private Node rightRotation(Node node) {
		Node newParent = node.left; 
		node.left = newParent.right; 
		newParent.right = node;
		update(node);
		update(newParent);		
		return newParent;
	}
	// -------------------------------------
	// Remove a value from this AVL Tree if exists
	public boolean remove(int elem) {
		if(contains(root,elem)) {
			root = remove(root,elem);
			count--;
			return true;
		}
		return false;
	}
	private Node remove(Node node, int elem) {
		// No Child
		if( node == null) return null;

		int cmp = node.value - elem;

		if(cmp < 0)
			node.left = remove(node.left,elem);
		else if(cmp > 0)
			node.right = remove(node.right,elem);
		// Found the node we wish to remove
		else { 
			if(node.left == null) // 1 Child or 0
				return node.right;

			else if(node.right == null) // 1 Child
				return node.left;
			else { // 2 Children
				// Choose to remove from left subtree
				if(node.left.height > node.right.height) { 
					// Swap the value of the predecessor into the node
					int predecessorValue = findMax(node.left);
					node.value = predecessorValue;

					// Find the largest node in the left subtree and remove
					node.left = remove(node.left,predecessorValue);
				}
				// Choose to remove from right subtree
				else {
					// Swap the value of the predecessor into the node
					int successorValue = findMin(node.right);
					node.value = successorValue;

					// Find the largest node in the left subtree and remove
					node.right = remove(node.right,successorValue);
				}
			}
		}
		// Update balance factor and height values.
		update(node);

		return balance(node);
	}
	private int findMax(Node current) {
		while(current.right != null)
			current = current.right;
		return current.value;
	}
	private int findMin(Node current) {
		while(current.left != null)
			current = current.left;
		return current.value;
	}
	// ******************* Print Function ********************************** //
	// Function to print binary tree in 2D  
	public void display() {
		if( root != null) {
			printTree(root.right, true, "");
			System.out.println(root.value);
			printTree(root.left, false, "");

		}
	}
	// Function to print binary tree in 2D  
	private void printTree(Node node, boolean isRight, String indent) {
		if(node != null) {
			printTree(node.right, true, indent + (isRight ? "        " : " |      "));
			System.out.print(indent);
			if (isRight) System.out.print(" /");
			else System.out.print(" \\");
			System.out.print("----- ");
			System.out.println(node.value);
			printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
	}
}
