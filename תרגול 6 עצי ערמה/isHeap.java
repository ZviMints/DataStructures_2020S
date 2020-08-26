package S7;
class isHeap
{
	// Function to check if given array represents Min-Heap or not
	public static boolean checkMinHeap(int[] A, int i)
	{
		// if i is a leaf node, return true as every leaf node is a heap
		if (2*i + 1 >= A.length) return true;

		// if i is an internal node
		
		// recursively check if left child is heap
		boolean left = (A[i] >= A[2*i + 1]) && checkMinHeap(A, 2*i + 1);

		// recursively check if right child is heap (to avoid array out
		// of bound, we first check if right child exists or not)
		boolean right = (2*i + 2 == A.length) ||
						(A[i] >= A[2*i + 2] && checkMinHeap(A, 2*i + 2));

		// return true if both left and right child are heap
		return left && right;
	}

	public static void main(String[] args)
	{
		int[] A = {6,5,4,3,2,1,0};

		// start with index 0 (root of the heap)
		int index = 0;
		System.out.println(checkMinHeap(A, index) ? "YES" : "NO");
	}
}

//This code contributed by 29AjayKumar  