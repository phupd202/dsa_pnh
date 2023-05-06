package ex_2;

public class BST {
    private Node root;
    private int n = 0;

    class Node {
        int data;
        Node left;
        Node right;

        // constructor
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // create Root
    public Node createRoot(int key) {
        if (n != 0) {
            throw new NullPointerException("cây đã tồn tại");
        } else {
            root = new Node(key, null, null);
            n++;
            return root;
        }
    }

    // insert Node
    public Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key, null, null);
        }
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // tìm phần tử bé nhất trên cây tìm kiếm nhị phân
    public int finMin(Node root) {
        if (root == null) {
            throw new NullPointerException("Cây rỗng");
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;

        }
        return p.data;
    }

    // Tìm phần tử liền sau của cây tìm kiếm nhị phân
    public Node inOrderSuccessor(Node root, Node key) {
        Node p = root;
        Node result = null;

        while (p != null) {
            if (p.data <= key.data) {
                p = p.right;
            } else {
                result = p;
                p = p.left;
            }

        }
        return result;
    }

    // Tìm kiếm phần tử liền trước và liền sau của cây tìm kiếm nhị phân
    public int[] predecessorAndSuccesor(Node root, Node key) {
        if (root == null) {
            return new int[2]; // Trả về một mảng trống
        }

        Node p = root;
        while (p != null && p.data != key.data) {
            if (p.data < key.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        int predecessor = p.left != null ? p.left.data : Integer.MIN_VALUE;
        int successor = p.right != null ? p.right.data : Integer.MAX_VALUE;

        return new int[] { predecessor, successor };
    }

    // Tìm giá trị phần tử lớn nhất trên cây tìm kiếm nhị phân mà không vượt quá N
    public int closestNeighbor(Node root, int N) {
        if (root == null) {
            return -1; // Trả về một giá trị không hợp lệ
        }
    
        int closest = root.data;
        Node p = root;
    
        while (p != null) {
            if (p.data == N) {
                return p.data; // Trả về giá trị N nếu đã có trong cây
            }
    
            if (Math.abs(p.data - N) < Math.abs(closest - N)) {
                closest = p.data;
            }
    
            if (p.data < N) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
    
        return closest;
    }
    

}
