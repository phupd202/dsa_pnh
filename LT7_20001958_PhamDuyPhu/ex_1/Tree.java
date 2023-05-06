package ex_1;

public class Tree {
    Node tree;
    private int n;
    
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

    public int size() {
        return n;
    }

    Node createRoot(int key) {
        if(n != 0) {
            throw new NullPointerException("cây đã tồn tại");
        } else {
            Node root = new Node(key, null, null);
            n++;
            return root;
        }
    }

    // duyet trung thứ tự, lấy phần tử xếp vào result
    void inOrder(Node root, int[] result, int n) {
        if(root == null) return;

        inOrder(root.left, result, n);
        result[n++] = root.data;
        inOrder(root.right, result, n);
    }

    // check cây có phải cây nhị phân hay không
    boolean isBST(Node root) {
        int n = size();
        int count = 0;
        int[] allElement = new int[n];

        // duyet cây trung thứ tư, lấy các phần tử xếp vào mảng
        inOrder(root, allElement, count);
        return isPepresenttingBST(allElement);
    }

    // kiểm tra một mảng có phải là BST duyệt theo trung thứ tự không
    public static boolean isPepresenttingBST(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i + 1] < a[i]) return false;
        }
        return true;
    }

    public double findMedian(Node root) {
        int n = size();
        int count = 0;
        int[] allElement = new int[n];

        // duyet cây trung thứ tư, lấy các phần tử xếp vào mảng
        inOrder(root, allElement, count);

        // find median
        if(n % 2 == 0) return allElement[n / 2];
        else {
            return (allElement[n / 2] + allElement[n/2 - 1]) / 2;
        }
    }

    // đêm giá trị của cây trong khoảng cho trước
    public int countNodeRange(Node root, int start, int end) {
        int n = size();
        int count = 0;
        int[] allElement = new int[n];

        // duyệt trung thứ tự
        inOrder(root, allElement, count);

        int numInRange = 0;
        for (int i = 0; i < allElement.length; i++) {
            if(allElement[i] <= end && allElement[i] <= start) {
                numInRange++;
            }
        }
        return numInRange;
    }

    // phần tử nhỏ thứ k trong cây tìm kiếm nhị phân
    public int k_Smallest(Node root, int k) {
        int n = size();
        int count = 0;
        int[] allElement = new int[n];

        // duyệt trung thứ tự
        inOrder(root, allElement, count);

        // find k_smallest in array
        return allElement[k - 1];

    }

    // phần tử lớn thứ k trong cây tìm kiếm nhị phân
    public int k_Largest(Node root, int k) {
        int n = size();
        int count = 0;
        int[] allElement = new int[n];

        // duyệt trung thứ tự
        inOrder(root, allElement, count);

        // find k_smallest in array
        return allElement[n - k];
    }


}
