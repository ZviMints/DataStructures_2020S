package S1;
import java.util.Arrays;
public class MyProgram {
	// Method to test above 
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1};
		InsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// A function to implement Insertion sort 
	public static void InsertionSort(int[] arr) {
		int n = arr.length;
		for(int i=1; i < n ; i++) {
			int key = arr[i];
			int j = i - 1;
			// Move elements from arr[0...i-1]
			// that are greater then key to one position
			// ahead of their current position
			while( j >= 0 && arr[j] > key ) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}

}
