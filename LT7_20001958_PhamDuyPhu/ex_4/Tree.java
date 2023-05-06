package ex_4;

import java.util.ArrayList;
import java.util.Collections;

import ex_3.BST;

public class Tree {

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // chuyển cây nhị phân thành cây tìm kiếm nhị phân
    public Node binaryTreeToBST(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);

        Collections.sort(nodes);
        return convertListToBST(nodes, 0, nodes.size() - 1);
    }

    
    public void inOrder(Node node, ArrayList<Integer> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node.value);
        inOrder(node.right, nodes);
    }

    public Node convertListToBST(ArrayList<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(nodes.get(mid));

        root.left = convertListToBST(nodes, start, mid - 1);
        root.right = convertListToBST(nodes, mid + 1, end);

        return root;
    }

    // kiểm tra 1 dãy cho trước có là kết quả của phép duyệt trước trên BST
    public boolean checkListIsBST(int[] elements) {
        int n = elements.length;
        BST bst = new BST();
        ex_3.BST.Node root = null;
    
        // build BST
        for (int i = 0; i < elements.length; i++) {
            root = bst.insert(elements[i], root);
        }

        int[] result = new int[n];
        bst.preOrder(root, elements, 0);

        // so sánh
        for (int i = 0; i < n; i++) {
            if(result[i] != elements[i]) {
                return false;
            }
        }
        return true;
    }

    // Tạo cây tìm kiếm nhị phân từ phép duyệt sau
    public Node buildTreeFromPost(int[] postorder) {
        int index = postorder.length - 1;
        return buildTreeFromPostHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, index, postorder);
    }

    private Node buildTreeFromPostHelper(int min, int max, int index, int[] postorder) {
        if (index < 0) {
            return null;
        }

        int val = postorder[index];
        if (val < min || val > max) {
            return null;
        }

        index--;
        Node root = new Node(val);
        root.right = buildTreeFromPostHelper(val, max, index, postorder);
        root.left = buildTreeFromPostHelper(min, val, index, postorder);

        return root;
    }

    // Chuyển đổi phép duyệt tiền tố thành hậu tố
    public void preToPost(int[] preorder, int[] postorder, int l, int r, int i) {
        // base case
        if(l == r) {
            postorder[i++] = preorder[l];
            return;
        }

        int j;
        for (j = l + 1; j < r; j++) {
            if(preorder[j] > preorder[l]); break;
            
        }
        preToPost(preorder, postorder, l + 1, j - 1, i);
        preToPost(preorder, postorder, j, r, i);
        postorder[i + r - l] = preorder[l];
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        Node root = tree.new Node(5);
        root.left = tree.new Node(20);
        root.right = tree.new Node(12);
        root.left.left = tree.new Node(17);
        root.right.right = tree.new Node(78);

    }
}
