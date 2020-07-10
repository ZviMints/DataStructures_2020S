package S1;
import java.util.Arrays;
public class MyProgram {
	// Method to test above 
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1};
		SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// A function to implement selection sort 
	public static void SelectionSort(int[] arr) {
		// One by one move boundary of unsorted subarray
		for(int i=0,n=arr.length; i < n-1 ; i++) {
			// Find the minimum element in unsorted array
			int min_index = i;
			for (int j=i+1; j<n; j++)
				if(arr[j] < arr[min_index])
					min_index = j;

			// Swap the minimum ele with the first element
			swap(arr,min_index,i);
		}
	}

	// Swap Functions
	public  static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
