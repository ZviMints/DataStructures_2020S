package S7;

import java.util.Arrays;
// Start at index 1
public class MaxHeap {
	int[] heap;
	int SIZE = 0 ;
	
	// Constructor
	public MaxHeap(int capacity)
	{
		if(capacity < 0 ) 
			throw new RuntimeException("capacity must be > 0");
		
		heap = new int[capacity + 1];  // Start with 1
		SIZE = 0; 
		heap[0] = Integer.MIN_VALUE; 

	}
	// Function to build a Max-Heap from the given array 
	public MaxHeap(int arr[]) // Build heap
	{ 
		// Copy the values 
		heap = new int[arr.length + 1];
		for(int i=1; i<heap.length; i++)
			heap[i] = arr[i-1];
		
		// Initialize First Value
		heap[0] = Integer.MIN_VALUE;
		
		// Initialize SIZE
		SIZE = heap.length - 1;
		
		buildHeap();
	} 
	private void buildHeap() { // O(n)
        // Build heap
		for(int i = SIZE/2; i >= 1; i--)
			Heapify(i);		
	}
	public int parent(int i)
	{
		if (i < 1 ) return -1;
		else return (i/2);
	}

	public int left(int i)
	{
		int answer = 2*i;
		if (answer > SIZE ) answer = -1;
		return answer;
	}

	public int right(int i)
	{
		int answer = 2*i + 1;
		if (answer > SIZE  ) answer = -1;
		return answer;
	}	
	
	public boolean add(int key)
	{
		if(SIZE == heap.length - 1) return false; // + 1 for starting at index 1
		else
		{
			heap[SIZE + 1] = key;
			SIZE ++;
			SwapUp(SIZE - 1);
			return true;

		}
	}
    // Traverse up and fix violated property 
	private void SwapUp(int index)
	{
		if(index != 1) // if its not the head
		{
			int parent = parent(index);  
			if(heap[parent] < heap[index])
			{
				swap(heap,parent,index);
				SwapUp(parent);
			}
		}
	}
	 // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
	public void Heapify(int i) // Down [After Remove]
	{
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left >= 1 && heap[left] > heap[largest])
			largest = left;
		if(right >= 1 && heap[right] > heap[largest])
			largest = right;
		
		// Now Largest is the maximum between i, right(i), left(i)
		if(largest != i)
		{
			swap(heap,largest,i);
			Heapify(largest);
		}
	}

	public int remove_max()
	{
		if(SIZE == 0) return Integer.MIN_VALUE; // if the heap is empty
		else
		{
			swap(heap,1,SIZE); // swap root with last item
			SIZE--; // delete the root ( he is the last item at the heap )
			Heapify(1); //maxHeapify from root
		}
		return heap[SIZE + 1]; // will show what deleted
	}


	public void swap(int[] heap, int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public int GetMax()
	{
		return heap[1];
	}

	public void print()  {
		System.out.println(Arrays.toString(heap));
	}
}
