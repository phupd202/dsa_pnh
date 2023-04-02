import java.util.Scanner;
import java.util.Stack;

public class ONP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());// số lượng test case

        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            System.out.println(infixToPos(s));
        }
        sc.close();
    }

    private static String infixToPos(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private static int getPriority(char op) {
        if (op == '*' || op == '/')
            return 2;
        else if (op == '+' || op == '-') 
            return 1;
        else if (op == '^') 
            return 3;
        return 0;
    }
}