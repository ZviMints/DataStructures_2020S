package S7;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] ArrayToSorted = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4};
		heapSort(ArrayToSorted);
		System.out.println(Arrays.toString(ArrayToSorted));
	}
	private static void heapSort(int[] arr) {
		/* O(n) extra space 
		MaxHeap heap = new MaxHeap(arr); // O(n)
		for(int i=0; i<arr.length; i++) { // O(nlogn)
			int max = heap.remove_max();
			arr[arr.length - i - 1] = max;
		}
		 */
		// Based Index 0
		int n = arr.length; 
		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 

		// One by one extract an element from heap 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Move current root to end [ Swap arr(i) and arr(0) ]
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			// call max heapify on the reduced heap 
			heapify(arr, i, 0); 
		}
	}
	private static void heapify(int[] arr, int n, int i) {
		 int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	}
}
