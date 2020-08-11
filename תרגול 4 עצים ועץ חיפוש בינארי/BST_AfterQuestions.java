package S4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// ******************* Zvi Mints - zvimints@gmail.com ********************************** //
public class BST_AfterQuestions
{
	// Root of BST 
	Node root;

	// Constructor 
	BST_AfterQuestions() {  root = null; } 

	// Returns minimum value in a given  
	// Binary Tree 
	public int returnMin()
	{
		Node current = root;
		while (current.left != null)
			current = current.left;
		return current.data;
	}

	// Returns maximum value in a given  
	// Binary Tree 
	public int returnMax()
	{
		Node current = root;
		while (current.right != null)
			current = current.right;
		return current.data;
	}

	// Returns true iff Node(key) in the  Tree
	public boolean search(int key)
	{
		Node current = root;

		while(current != null)
		{
			if(current.data == key) return true;
			else if(key > current.data ) current = current.right;
			else current = current.left;
		}
		return false;
	}

	/* Compute the "maxDepth" of a tree -- the number of  
	nodes along the longest path from the root node  
    down to the farthest leaf node.*/
	public int getHeight()
	{
		return getHeight(root);	
	}

	public int getHeight(Node current)
	{
		int result = -1;
		if(current != null)
		{
			int LeftHeight = getHeight(current.left);
			int RightHeight = getHeight(current.right);
			result = Integer.max(LeftHeight, RightHeight) + 1;
		}
		return result;
	}
	/* Given a binary tree, print its nodes according to the PreOrder */
	public void PreOrder() // (V,L,R)
	{
		PreOrder(root);
	}
	public void PreOrder(Node current)
	{
		if(current != null)
		{
			System.out.print(current.data + " " );
			PreOrder(current.left);
			PreOrder(current.right);
		}
	}
	/* Given a binary tree, print its nodes according to the InOrder */
	public void InOrder() // (L,V,R)
	{
		InOrder(root);
	}
	public void InOrder(Node current)
	{
		if(current != null)
		{
			InOrder(current.left);
			System.out.print(current.data + " " );
			InOrder(current.right);
		}
	}
	/* Given a binary tree, print its nodes according to the PostOrder */
	public void PostOrder() // (L,R,V)
	{
		PostOrder(root);
	}
	public void PostOrder(Node current)
	{
		if(current != null)
		{
			PostOrder(current.left);
			PostOrder(current.right);
			System.out.print(current.data + " " );
		}
	}
	public void add(int key)
	{
		Node NewNode = new Node(key); // Make New Node
		Node current = root;
		if(current == null)
			root = NewNode;
		else
		{
			boolean exit = false;
			while(!exit)
			{
				if(key < current.data)
				{
					if(current.left == null)
					{
						// put here
						current.left = NewNode;
						exit = true;
					}
					else
						current = current.left;
				}
				else if(key > current.data)
				{
					if(current.right == null)
					{
						// put here
						current.right = NewNode;
						exit = true;
					}
					else
						current = current.right;
				}

			}
		}
	}
	// This method mainly calls deleteRec() 
	public void delete(int key) {
		root = deleteRec(root, key); 
	}

	/* A recursive function to insert a new key in BST */
	private Node deleteRec(Node root, int key) {

		/* Base Case: If the tree is empty */
		if(root == null) return root;

		/* Otherwise, recur down the tree */
		if(key  < root.data)
			root.left = deleteRec(root.left, key); 
		else if (key > root.data) 
			root.right = deleteRec(root.right, key); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else {

			// node with no child 
			if( root.left == null && root.right == null) return null;

			// node with only one child
			if (root.left == null)  // No Left Child
				return root.right; 
			else if (root.right == null) // No Right Child
				return root.left;

			// nodes with two children

			// Find Minimum Value
			Node current = root.left;
			while(current.right != null ) current = current.right;
			int minValue = current.data; 

			// Set root data to minimum value
			root.data = minValue;

			// Delete the node
			root.left = deleteRec(root.left, minValue);
		}
		return root;
	}

	// ******************* Print Function ********************************** //
	// Function to print binary tree in 2D  
	public void printTree() {
		if( root != null) {
			printTree(root.right, true, "");
			System.out.println(root.data);
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
			System.out.println(node.data);
			printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
	}
	// ******************* From Moodle ********************************** //
	// Ex10
	public void printInorder(){ InOrder(); }
	public void printPostorder (){ PostOrder(); }

	/* Computes the number of nodes in a tree. */
	public int size(){ 
		return size(root);
	}

	public int size(Node current) {
		if(current == null) return 0;
		else
			return size(current.left) + size(current.right) + 1;
	}

	// Ex11

	// Function to calculate number 
	// of children of given node 
	public int numOfChilds(int data){
		Node current = root;
		boolean exists = this.search(data);
		if(!exists) return Integer.MIN_VALUE;
		while(current.data != data) {
			if(current.data == data) break;
			else if(data > current.data) current = current.right;
			else 
				current = current.left;
		}
		return numOfChilds(current.left) + numOfChilds(current.right);
	}
	public int numOfChilds(Node current) {
		if(current == null) return 0;
		else
			return 1 + numOfChilds(current.right) + numOfChilds(current.left);
	}

	// Helper
	public String toString(){ 
		return "<" + toString(root) + ">";
	}

	// recursively printing out the nodes
	private String toString(Node n) {
		if(n == null) return "";
		else return n.data + "," + toString(n.right) + toString(n.left);
	}

	public int numOfLeaves(){ 
		return numOfLeaves(root);
	}
	private int numOfLeaves(Node curr) {
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null) return 1;
		else return numOfLeaves(curr.left) + numOfLeaves(curr.right);
	}

	public int numOfParents (){ 
		return numOfParents(root);

	}
	private int numOfParents(Node curr) {
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null) return 0;
		else return 1 + numOfParents(curr.left) + numOfParents(curr.right);
	}

	public BST_AfterQuestions(BST_AfterQuestions other){
		if(other == null) return;
		if(root == null && other != null) {
			root = new Node(other.root.data);
			DeepCopy(root,other.root);
		}
	}
	public void DeepCopy(Node ours, Node other) {
		ours.data = other.data;
		if(other.left != null) {
			ours.left = new Node(other.left.data);
			DeepCopy(ours.left,other.left);
		}
		if(other.right != null) {
			ours.right = new Node(other.right.data);
			DeepCopy(ours.right,other.right);
		}
	}
	// ******************* Question 1 ********************************** //
	public boolean isBST() { 
		return isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBST(Node curr, int min, int max) {
		/* an empty tree is BST */
		if (curr == null) 
			return true; 

		/* false if this node violates the min/max constraints */
		if (curr.data < min || curr.data > max) 
			return false; 

		/* otherwise check the subtrees recursively 
        tightening the min/max constraints */
		// Allow only distinct values 
		return (isBST(curr.left, min, curr.data-1) && 
				isBST(curr.right, curr.data+1, max)); 
	}

	// Find minimum value function in Binary Tree:
	public static int minValue(Node current) {
		if(current == null) return Integer.MAX_VALUE;
		int data = current.data;
		int rdata = minValue(current.right);
		int ldata = minValue(current.left);
		if(rdata < data) data = rdata;
		if(ldata < data) data = ldata;
		return data;
	}

	// ******************* Question 2 ********************************** //
	public static boolean isIdentical(Node x, Node y) { 
		/*1. both empty */
		if (x == null && y == null) 
			return true; 

		/* 2. both non-empty -> compare them */
		if (x != null && y != null)  
			return (x.data == y.data 
			&& isIdentical(x.left, y.left) 
			&& isIdentical(x.right, y.right)); 

		/* 3. one empty, one not -> false */
		return false; 
	}
	// ******************* Question 3 ********************************** //
	// Utility function to swap left subtree with right subtree
	public static void swap(Node root) {
		if (root == null) { return; }

		Node temp = root.left;
		root.left =  root.right;
		root.right = temp;
	}

	// Function to convert given binary Tree to its mirror
	public static void convertToMirror(Node root)
	{
		// base case: if tree is empty
		if (root == null) { return; }
		// convert left subtree
		convertToMirror(root.left);

		// convert right subtree
		convertToMirror(root.right);

		// swap left subtree with right subtree
		swap(root);
	}
	// ******************* Question 4 ********************************** //
	public int findLCA(int n1, int n2) 
	{ 
		return findLCA(root, n1, n2).data; 
	} 

	// This function returns pointer to LCA of two given 
	// values n1 and n2. This function assumes that n1 and 
	// n2 are present in Binary Tree 
	public Node findLCA(Node node, int n1, int n2) 
	{ 
		if (node == null) 
			return null; 

		// If both n1 and n2 are smaller than root, then LCA lies in left 
		if (node.data > n1 && node.data > n2) 
			return findLCA(node.left, n1, n2); 

		// If both n1 and n2 are greater than root, then LCA lies in right 
		if (node.data < n1 && node.data < n2)  
			return findLCA(node.right, n1, n2); 

		return node; 
	} 

	// ******************* Question 5 ********************************** //
	public int kthSmallest(Node root, int k) {
		if( k > size() ) return Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		InOrder(root, list);
		return list.get(k - 1);
	}


	private void InOrder(Node root, List<Integer> list) {
		if (root == null) return;
		InOrder(root.left, list);
		list.add(root.data);
		InOrder(root.right, list);
	}
	// ******************* Question 6 ********************************** //
	public String isLeaf(int data){ 
		Node current = root;
		while(current != null) {
			if( data == current.data) break;
			else if( data > current.data ) current = current.right;
			else current = current.left;
		}
		if(current == null) return "not a vertex";
		else if ( current.right != null || current.left != null ) return "not a leaf";
		else return "leaf";
	}
	// ******************* Question 7 ********************************** //
	// A:
	public void add (Node node, Node z) {
		if(node == null)
			root = z;
		else {
			boolean exit = false;
			while(!exit) {
				if(z.data < node.data) {
					if(node.left == null) 
					{
						// Put Here
						node.num ++ ;
						node.left = z;
						exit = true;
					}
					else {
						node.num ++ ;
						node = node.left;
					}
				}
				else { // z.data < node.data
					if(node.right == null) 
					{
						// Put Here
						node.num ++ ;
						node.right = z;
						exit = true;
					}
					else {
						node.num++;
						node = node.right;
					}
				}
			} // End While
		}
	}

	// B:
	public int less(Node node, int x) {
		// Base Case:
		if ( node == null ) return 0;
		else if ( x == node.data ) {
			if(node.left != null)
				return node.left.num;
			else
				return 0;
		}
		else if( x > node.data ) {
			if(node.left != null)
				return node.left.num + 1 + less(node.right,x);
			else
				return 1 + less(node.right,x);
		}
		else
			return less(node.left,x);
	}
	// ******************* Question 8 ********************************** //
	public static void printTreeByLevels(BST_AfterQuestions tree) {
		// Base Case 
		if(tree.root == null) 
			return; 

		// Create an empty queue for level order tarversal 
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height 
		q.add(tree.root);
		while(!q.isEmpty()) {

			int NumberOfNodesAtCurrentLevel = q.size();

			while(NumberOfNodesAtCurrentLevel > 0 ) {
				Node top = q.poll();
				System.out.print(top.data + " ");
				if(top.left != null)
					q.add(top.left);
				if(top.right != null)
					q.add(top.right);
				NumberOfNodesAtCurrentLevel--;
			}

			System.out.println();
		}
	}
	// ******************* Question 9 ********************************** //
	public boolean isFullTree(Node node) {
		// if empty tree 
		if(node == null) 
			return true; 

		// if leaf node 
		if(node.left == null && node.right == null ) 
			return true; 

		// if both left and right subtrees are not null 
		// Return Recur on Left subtree and right Subtree
		if((node.left != null) && (node.right != null)) 
			return (isFullTree(node.left) && isFullTree(node.right)); 

		// if none work 
		return false; 
	}
	// ******************* Question EXTRA ********************************** //
	public Node returnNodeInBinaryTree(Node current,int key) {
		if(current == null) return null;
		if(current.data == key) return current;
		Node r = returnNodeInBinaryTree(current.right,key);
		Node l = returnNodeInBinaryTree(current.left,key);
		if(r != null) return r;
		if(l != null) return l;
		return null;
	}
}
