import java.util.NoSuchElementException;

public class BST implements AbstractAST {
    Node root;

    @Override
    public int max() {
        Node current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    @Override
    public int min() {
        return min(root);
    }

    private int min(Node current) {
        return (current.left == null) ? current.data : min(current.left);
    }


    public boolean contains(int key) {
        return contains(key, root) != null;
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

    public int height(Node current) {
        if (current == null) return -1;
        return Integer.max(height(current.left), height(current.right)) + 1;
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
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
        inOrder(this.root);
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }


    @Override
    public void add(int value) {
        root = add(value, root);
    }

    private Node add(int value, Node current) {
        if (current == null) current = new Node(value);
        else {
            if (value < current.data) current.left = add(value, current.left);
            else if (value > current.data) current.right = add(value, current.right);
            else throw new RuntimeException("Already exists");
        }
        return current; // return new tree after insertion
    }

    @Override
    public void delete(int key) {
      root = delete(key,root);
    }
    private Node delete(int key, Node current) {
        if (current == null)  return null;

        if (key < current.data)  current.left = delete(key, current.left);
        else if (key > current.data) current.right = delete(key, current.right);

        else
        {
            if (current.left == null)  return current.right;
            else if (current.right == null) return current.left;

            current.data = min(current.right);
            current.right = delete(current.data, current.right);
        }

        return current;
    }


    @Override
    public int size() {
        return size(root);
    }
    private int size(Node current) {
        if(current == null) return 0;
        else return size(current.left) + size(current.right) + 1;
    }
}
