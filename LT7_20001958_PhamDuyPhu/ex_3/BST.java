package ex_3;

public class BST {

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public Node createRoot(int keyRoot) {
        Node root = new Node(keyRoot, null, null);
        return root;
    }


    public boolean search(int key, Node root) {
        if(root == null) return false;

        if(root.data == key) {
            return true;
        }

        if(key < root.data) {
            return search(key, root.left);
        } else {
            return search(key, root.right);
        }

        // Node p = root;
        // while(p != null) {
        //     if(key < p.data) {
        //         p = p.left;
        //     }
        //     if(key > p.data) {
        //         p = p.right;
        //     }
        //     if(key == p.data) {
        //         return true;
        //     }
        // }
        // return false;
    }

    public Node insert(int key, Node root) {
        if(root == null) {
            return createRoot(key);
        }

        if(key < root.data) {
           root.left =  insert(key, root.left);
        } else {
            root.right = insert(key, root.right);
        }
        return root;

    }

    public int getRightMin(Node node) {
        Node p = node;
        p = p.right;
        while(p.left != null) {
            p = p.left;
            
        }
        return p.data;
    }
    
    public Node delete(int key, Node root) {
        if(root == null) {
            return null;
        }
        
        if(key < root.data) {
            root.left = delete(key, root.left);
        } else if (key > root.data) {
            root.right = delete(key, root.right);
        } else {
            if(root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // nút có 2 con 
                root.data = getRightMin(root);
                root.right = delete(root.data, root.right);
            }
        }
        return root;
    }

    // xoá mọi phần tử lớn hơn K trong BST
    public Node deleteCeilK(int k, Node root) {
        if(root == null) {
            return null;
        }

        if(k >= root.data) {
            root.right = deleteCeilK(k, root.right);
        } else {
            root = delete(root.data, root);
            root.left = deleteCeilK(k, root.left);
        }
        return root;
    }

    // thay đổi khoá phần tử
    public Node changeKey(int oldKey, int newKey, Node root) {
        if(!search(oldKey, root)) {
            return root;
        }

        root = delete(oldKey, root);
        root = insert(newKey, root);
        return root;
    }

    // Duyệt tiền thứ tự, lấy phần tử xếp vào result
    public void preOrder(Node root, int[] result, int n) {
        if(root == null) return;

        result[n++] = root.data;
        preOrder(root.left, result, n);
        preOrder(root.right, result, n);
    }
}
