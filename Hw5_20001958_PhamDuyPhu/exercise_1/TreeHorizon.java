package Hw5_20001958_PhamDuyPhu.exercise_1;

import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree.Node;

/*
 * In cây theo chiều ngang
 */
public class TreeHorizon {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<Integer>();

        // create tree
        tree.setRoot(1);

        tree.setLeft(1, 2);
        tree.setRight(1, 3);

        tree.setLeft(2, 4);
        tree.setRight(2, 5);

        tree.setLeft(5, 6);
        tree.setRight(5, 7);

        // Print cây
        

    }

    <E> void printTreeHorizon(Node<E> tree) {
        
        

    }
}
