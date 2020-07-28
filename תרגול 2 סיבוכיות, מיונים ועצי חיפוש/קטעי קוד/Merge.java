package S2;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		int[] SortedA = {1,2,3,9};
		int[] SortedB = {0,4,5,6};
		System.out.println(Arrays.toString(Merge(SortedA,SortedB)));
	}

	private static int[] Merge(int[] sortedA, int[] sortedB) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] C = new int[sortedA.length + sortedB.length];
		while(i < sortedA.length && j < sortedB.length) {
			if(sortedA[i] < sortedB[j]) C[k++] = sortedA[i++];
			else C[k++] = sortedB[j++];
		}
		while( i < sortedA.length)
			C[k++] = sortedA[i++];
		while(j < sortedB.length)
			C[k++] = sortedB[j++];
		return C;
		
		
	}

}
