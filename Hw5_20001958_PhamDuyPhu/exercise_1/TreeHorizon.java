package Hw5_20001958_PhamDuyPhu.exercise_1;

import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree.Node;

/*
 * Bài 1.3: In cây theo chiều ngang
 */
public class TreeHorizon {
    public static void main(String[] args) {
        LinkedListTree<Integer> tree = new LinkedListTree<Integer>();

        // create tree
        Node<Integer> root = tree.addRoot(1);
        Node<Integer> lNode1 = tree.addLeft(root, 5);
        Node<Integer> rNode1 = tree.addRight(root, 3);
        root.setLeft(lNode1);
        root.setRight(rNode1);

        Node<Integer> lNode2 = tree.addLeft(lNode1, 8);
        Node<Integer> rNode2 = tree.addRight(lNode1, 6);
        lNode1.setLeft(lNode2);
        lNode1.setRight(rNode2);

        Node<Integer> lNode3 = tree.addLeft(rNode1, 2);
        Node<Integer> rNode3 = tree.addRight(rNode1, 7);
        rNode1.setLeft(lNode3);
        rNode1.setRight(rNode3);

        // Print cây
        printTree(root, 0);


    }

    public static void printTree(Node<Integer> node, int count) {
        if (node == null) {
            return;
        }
        
        printTree(node.getRight(), count + 5);
        
        // Mỗi lần gọi đệ quy tăng count(số space lên 5)
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
        
        System.out.println(node.getElement());

        printTree(node.getLeft(), count + 5);
    }
    
}
