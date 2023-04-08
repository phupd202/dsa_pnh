package Hw5_20001958_PhamDuyPhu.exercise_3;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Stack;

import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree;
import Hw5_20001958_PhamDuyPhu.exercise_1.LinkedListTree.Node;

public class BuildTree {
    // infix to postfix
    public static String infixtoPosFix(String s) {
        Stack<Character> stack = new Stack<Character>();
        String posfix = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {

                // xử lý toán hạng được nối liền nhau, chăng hạn 50 là 50 chứ ko phải 5 và 0
                if (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                    posfix += c;
                } else {
                    posfix += " " + c;
                }

            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    posfix += " " + stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    posfix += " " + stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            posfix += " " + stack.pop();
        }

        return posfix.trim();
    }

    // get priority
    public static int getPriority(char op) {
        if (op == '*' || op == '/')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return 0;
    }

    // buil cây biểu thức từ biểu thức hậu tố
    public static Node<Character> buildExpressionTree(String postfix) {
        LinkedListTree<Character> tree = new LinkedListTree<>();
        Stack<Node<Character>> stack = new Stack<>();
    
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            Node<Character> root = new Node<Character>(ch, null, null, null);

            if (Character.isDigit(ch)) {
                stack.push(root);
            } else if (isOperator(ch)) {
                Node<Character> rightNode = stack.pop();
                root.setRight(rightNode);
                
                Node<Character> leftNode = stack.pop();
                root.setLeft(leftNode);
                
                stack.push(root);
            } else {
                continue;

            }
        }
    
        return stack.pop();
    }

    // check oparator
    public static boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '/' || c == '*') {
            return true;
        }
        return false;
    }

    // Duyêt cây dưng từ xâu hậu tố
    public static void inorderPrint(Node<Character> p) {
        if (p == null) {
            return;
        }

        inorderPrint(p.getLeft());
        System.out.print(p.getElement() + ", ");
        inorderPrint(p.getRight());

    }

    public static void main(String[] args) {
        String s = "(1+2)*3-4";
        System.out.println("Biều diễn hậu tố của chuỗi là: ");

        // chuyển sang hậu tố
        String posStr = infixtoPosFix(s);
        System.out.println(posStr);

        // Buil cây biểu thức từ xâu hậu tố
        Node<Character> expTree = buildExpressionTree(posStr);

        //In ra cây hậu tố
        System.out.println("Duyệt cây biểu thức trung thứ tự: ");
        inorderPrint(expTree);
        
    }

}
