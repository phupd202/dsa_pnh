package Hw5_20001958_PhamDuyPhu.exercise_2;

import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree.Node;

public class CalValue {
    public static void main(String[] args) {
        // Xây dựng cây biểu thức và sử dụng duyệt trung thứ tự tính giá trị biểu thức
        // biểu thức (1 + 2) * 3
        ExpressionTree<Character> tree = new ExpressionTree<Character>();

        System.out.println("Duyệt cây biểu thức:  ");
        Node<Character> root = tree.addRoot('*');

        Node<Character> lNode1 = tree.addLeft(root, '+');
        Node<Character> rNode1 = tree.addRight(root, '3');
        
        root.setLeft(lNode1);
        root.setRight(rNode1);

        Node<Character> lNode2 = tree.addLeft(lNode1, '1');
        Node<Character> rNode2 = tree.addRight(lNode1, '2');
        
        lNode1.setLeft(lNode2);
        lNode1.setRight(rNode2);

        // duyệt cây trung thứ tự
        tree.inorderPrint(root);

        // chuyển sang dạng hậu thứ tự
        System.out.println("Biểu diễn hâu thứ tự: ");
        tree.postorderPrint(root);

        // Tính giá trị của cây biểu thức cho trước
        System.out.println("Giá trị của biếu thức trên là: ");
        System.out.print(calValue(root));
    }
    

    // tính giá trị biếu thức bằng kiểu duyệt trung thứ tự
    static double calValue(Node<Character> tree) {

        double f = 0;
        if(tree.getLeft() == null && tree.getRight() == null) { // tức là nút là
            char result = tree.getElement();
            return Double.parseDouble(String.valueOf(result));
        }

        double a1 = calValue(tree.getLeft());
        double b1 = calValue(tree.getRight());

        char op = tree.getElement();

        switch(op) {
            case '+':
                f = a1 + b1;
            break;

            case '-':
                f = a1 - b1;
            break;
            
            case '/':
                f = a1 / b1;
            break;

            case '*':
                f = a1 * b1;
            break;
        }
        return f;
    }
}
