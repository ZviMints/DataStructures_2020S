package S7;

import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(new int[]{1,2,3,4,5,6,7,8});
		heap.print();
		//               8
		//           5       7
		//         4   1    6  3
		//       2
		System.out.println(heap.GetMax());
	}
}
