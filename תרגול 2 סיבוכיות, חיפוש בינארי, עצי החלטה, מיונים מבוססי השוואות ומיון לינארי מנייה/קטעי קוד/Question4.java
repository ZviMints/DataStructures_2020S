package S1;
import java.util.Arrays;
public class Question7 {

	public static void main(String[] args) {
		int[] arr = {1,6,1,6,6,1,6,1,1,6,6};
		Question4(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void Question4(int[] arr) {
		int first_num = arr[0];
		int second_num = getSecondNumber(arr,first_num);
		
		int low = 0;
		int high = arr.length - 1;
		while( low <= high ) {
			if(arr[low] == first_num ) low++;
			else if(arr[high] == second_num ) high--;
			else {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++; high++;
			}
		}
	}
	private static int getSecondNumber(int[] arr, int first_num) {
		for(int i=1,n=arr.length; i<n; i++)
			if(arr[i] != first_num)
				return arr[i];
		throw new IllegalArgumentException("All numbers are the same");
	}
}
