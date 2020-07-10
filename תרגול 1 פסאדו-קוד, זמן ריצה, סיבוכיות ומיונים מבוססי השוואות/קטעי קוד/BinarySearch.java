package S1;
import java.util.Arrays;
public class MyProgram {
	// Method to test above 
	public static void main(String[] args) {
		int[] sortedArray = {1,2,3};
		int key = 2; // Prints Not Found  
		int index = Arrays.binarySearch(sortedArray, key);
		System.out.println((index > 0) ? index : "Not Found");

	}

	public int binarySearch( int[] sortedArray, int key, int low, int high) {
		int middle = (low + high) / 2;  
		if (high < low) { return -1; } // תנאי עצירה
		if (key == sortedArray[middle])  { return middle; } // תנאי עצירה
		else if (key < sortedArray[middle])  //חיפוש בצד שמאל 
			return binarySearch(sortedArray, key, low, middle - 1); 
		else  // חיפוש בצד ימין 
			return binarySearch(sortedArray, key, middle + 1, high);
	}
}
