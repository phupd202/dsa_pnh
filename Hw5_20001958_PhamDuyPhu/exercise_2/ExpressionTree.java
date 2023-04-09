package Hw5_20001958_PhamDuyPhu.exercise_2;

import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree;

/*
 * Bài 2.1: 
 */
public class ExpressionTree<E> extends LinkedListTree<E> {
    // tiền thứ tự
    public void preorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        System.out.println(p.getElement() + " ");
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    // hậu thứ tự
    public void postorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.println(p.getElement() + " ");

    }

    // trung thứ thứ tự
    public void inorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        inorderPrint(p.getLeft());
        System.out.println(p.getElement() + " ");
        inorderPrint(p.getRight());

    }

    

    public static void main(String[] args) {
        ExpressionTree<Integer> tree = new ExpressionTree<Integer>();
        Node<Integer> root = tree.addRoot(1);

        root.setLeft(tree.addLeft(root, 2));
        root.setRight(tree.addRight(root, 3));

        /*
         * Bài 2.2: Sử dụng phương thức đó để in ra các dạng biểu diễn của cây cho trước
         */
        // tiền thứ tự
        System.out.println("Duyệt cây tiền thứ tự: ");
        tree.preorderPrint(root);

        // trung thứ tự
        System.out.println("Duyệt cây trung thứ tự: ");
        tree.inorderPrint(root);

        // hậu thứ tự
        System.out.println("Duyệt cây hậu thứ tự: ");
        tree.postorderPrint(root);

        



    }
}
