package S1;

import java.util.Arrays;

public class Question0 {

	public static void main(String[] args) {
		int[] arr = {1,2,-6,3,4,5};
		int[] ans = MinMax(arr); 
		System.out.println(Arrays.toString(ans));
	}

	private static int[] MinMax(int[] arr) {
		return MinMax(arr,0,arr.length - 1);
	}
	private static int[] MinMax(int[] arr, int low, int high) {
		if( low == high ) // arr size is 1
			return new int[]{arr[low],arr[high]}; 
		else if(high - low == 1) // arr size is 2
			return new int[]{Math.min(arr[low],arr[high]),Math.max(arr[low], arr[high])}; // O(1)		 			
		else { // arr size > 2
			int middle = ( low + high ) / 2; 
			// recursive for max and min of left half
			int[] res1 = MinMax(arr,low,middle); 
			// recursive for max and min of right half
			int[] res2 = MinMax(arr,middle+1,high); 
			// one comparison determines true max of two candidates
			// one comparison determines  true min of two candidates
			return new int[] {Math.min(res1[0], res2[0]),Math.max(res1[1], res2[1])}; 
		}


}

}
