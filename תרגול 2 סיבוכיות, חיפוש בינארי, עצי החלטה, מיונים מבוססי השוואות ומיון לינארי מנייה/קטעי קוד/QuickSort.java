package S1;

import java.util.Arrays;
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		QuickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void QuickSort(int[] arr)
	{
		QuickSort(arr,0,arr.length-1);
	}
	private static void QuickSort(int[] arr,int start, int end)
	{
		if(start < end)
		{
			int pivot = Partition(arr,start,end);
			QuickSort(arr,start,pivot-1);
			QuickSort(arr,pivot+1,end);
		}
	}
	private static int Partition(int[] arr,int low, int high)
	{
		int pivot = low;
		low++; // [Pivot, Low ... High]
		swap(arr,pivot,pivot + (int) Math.random()*(high-low)); // Swap pivot with

		while(low <= high)
		{
			if(arr[low] < arr[pivot]) low++;
			else if(arr[high] >= arr[pivot]) high--;
			else
				swap(arr,low,high);
		}
		swap(arr,pivot,high); // Pivot = H
		return high;
	}
	private static void swap(int[] arr,int i, int j)
	{ 
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}