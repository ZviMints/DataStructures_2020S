package S1;
import java.util.Arrays;
public class Question6 {

	public static void main(String[] args) {
		int[] arr = {-3,6,12,4,-7,45,-6,-3,-1,2,3,10,1,2,3,4,5};
		Question3(arr);
		System.out.println(Arrays.toString(arr));
	}
	// This function is responsible to partition the array into even side and odd side
	// [even.....odd]
	private static void Question3(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			if(arr[low]%2 == 0) low++; // Will Stay at the first that odd
			else if(arr[high]%2 != 0) high--; // Will stay at the first that even
			else {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				high++; low++;
			}
		}
	}

}
