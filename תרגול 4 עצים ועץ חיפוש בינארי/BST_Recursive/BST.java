// ******************* Zvi Mints - zvimints@gmail.com ********************************** //

interface AbstractBST {
    public int min();

    public int max();

    public boolean contains(int key);

    public int height();

    public void preOrder();

    public void inOrder();

    public void postOrder();

    public void add(int value);

    public void delete(int key);

    public int size();
}


class BST implements AbstractBST {
    Node root;

    @Override
    public int min() { return min(root); }
    private int min(Node current) {
        return current.left == null ? current.data : min(root.left);
    }

    @Override
    public int max() {
        Node current = root;
        while (current != null) current = current.right;
        return current.data;
    }

    @Override
    public boolean contains(int key) {
        return contains(key, root) == null;
    }

    private Node contains(int key, Node current) {
        if (current.data == key) return current;
        else if (current.data < key) return contains(key, current.right);
        else return contains(key, current.left);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node current) {
        if (current == null) return -1;
        else return Integer.max(height(current.left), height(current.right)) + 1;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current != null) {
            preOrder(current.left);
            System.out.print(current.data + " ");
            preOrder(current.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node current) {
        if (current != null) {
            preOrder(current.left);
            preOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    @Override
    public void add(int value) {
        root = add(value, root);
    }

    public Node add(int value, Node current) {
        if (current == null) return new Node(value);
        else {
            if (value < current.data) current.left = add(value, current.left);
            else if (value > current.data) current.right = add(value, current.right);
            else throw new RuntimeException("Already Exists");
        }
        return current;
    }

    @Override
    public void delete(int key) {
        root = delete(key, root);
    }
    private Node delete(int key, Node current) {

        Node element = contains(key, current);
        // Not in tree
        if(current == null) return null;

        // Leaf
        if (current.left == null && current.right == null) {
            return null;
        }

        // One Children
        if (current.right == null) {
            return current.left;
        }

        if (current.left == null) {
            return current.right;
        }

        // Two Children
        int smallestValue = min(current.right);
        current.data = smallestValue;
        current.right = delete(smallestValue, current.right);
        return current;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node current) {
        if (current == null) return 0;
        else return size(current.left) + size(current.right) + 1;
    }
}
