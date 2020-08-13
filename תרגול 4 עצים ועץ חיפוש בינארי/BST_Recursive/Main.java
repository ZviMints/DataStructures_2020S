public class Main {
    public static void main(String[] args) {
        AbstractBST tree = new BST();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(-2);
        tree.add(0);
        try { tree.add(1); assert(false); } catch(Exception e) { assert(true); }
        assert(tree.min() == -1);
        assert(tree.max() == 3);
        assert(tree.height() == 3);
        assert(tree.size() == 5);
        tree.delete(3);
        tree.inOrder();
    }
}
