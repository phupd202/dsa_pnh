package Hw5_20001958_PhamDuyPhu.exercise_1;

public class LinkedListTree<E> {
    private int n = 0;
    
    public static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child

        // Constructs
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.setElement(e);
            this.parent = above;
            this.setLeft(leftChild);
            this.setRight(rightChild);
        }

        public Node<E> getRight() {
            return this.right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public E getElement() {
            return this.element;
        }

        public void setElement(E element) {
            this.element = element;
        }

    }

    // update methods
    public Node<E> addRoot(E element) {
        // if (n > 0) {
        //     throw new IllegalStateException("Cây đã có nút gốc");
        // }
        Node<E> root = new Node<E>(element, null, null, null);
        n++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (isEmpty()) {
            throw new NullPointerException("Cây rỗng, hãy tạo nút gốc!!");
        }
        if (p == null) {
            throw new NullPointerException("Node hiện tại đang rỗng, không thể set up nút trái!!");
        }

        if (p.getLeft() != null) {
            throw new IllegalArgumentException("Nút trái đã tồn tại");
        }
        Node<E> node = new Node<E>(element, p, null, null);
        n++;
        return node;

    }

    public Node<E> addRight(Node<E> p, E element) {
        if (isEmpty()) {
            throw new NullPointerException("Cây rỗng, hãy tạo nút gốc!!");
        }
        if (p == null) {
            throw new NullPointerException("Node hiện tại đang rỗng, không thể set up nút phải!!");
        }

        if (p.getRight() != null) {
            throw new IllegalArgumentException("Nút phải đã tồn tại");
        }
        Node<E> node = new Node<E>(element, p, null, null);
        n++;
        return node;
    }

    public void set(Node<E> p, E element) {
        p.setElement(element);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // duyệt cây trung thứ tự
    public void inOrder(Node<E> p) {
        if (p == null) {
            return;
        }

        inOrder(p.getLeft());
        System.out.print(p.getElement() + " ");
        inOrder(p.getRight());
    }

    public static void main(String[] args) {
        LinkedListTree<Integer> tree = new LinkedListTree<Integer>();
        Node<Integer> root = tree.addRoot(1);

        root.setLeft(tree.addLeft(root, 2));
        root.setRight(tree.addRight(root,3));

        // In ra cây
        tree.inOrder(root);

        

    }

}
