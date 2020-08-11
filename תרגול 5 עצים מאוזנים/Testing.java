package S5;

import java.util.stream.IntStream;

public class Testing {

	public static void main(String[] args) {
		int[] vals = {10, 20, 15, 25, 30, 16, 18, 19};
		AVLTree tree = new AVLTree();
		for(int num : vals)
			tree.insert(num);
		
		tree.display();
		
		System.out.println();
		
		tree.remove(30);
		tree.display();
			
	}

}
