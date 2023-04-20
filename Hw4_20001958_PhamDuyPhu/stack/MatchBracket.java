package Hw4_20001958_PhamDuyPhu.stack;

import java.util.Stack;

public class MatchBracket {
    public static int evaluate(String expression) {
        LinkedListStack<Character> opStack = new LinkedListStack<>();
        LinkedListStack<Integer> valStack = new LinkedListStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }

                i--;
                valStack.push(num);
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.top() != '(') {
                    char op = opStack.pop();
                    int val2 = valStack.pop();
                    int val1 = valStack.pop();
                    int result = evaluateOperation(op, val1, val2);
                    valStack.push(result);
                }

                if (!opStack.isEmpty() && opStack.top() == '(') {
                    opStack.pop();
                }
            } else if (isOperator(c)) {
                while (!opStack.isEmpty() && precedence(c) <= precedence(opStack.top())) {
                    char op = opStack.pop();
                    int val2 = valStack.pop();
                    int val1 = valStack.pop();
                    int result = evaluateOperation(op, val1, val2);
                    valStack.push(result);
                }

                opStack.push(c);
            }
        }

        while (!opStack.isEmpty()) {
            char op = opStack.pop();
            int val2 = valStack.pop();
            int val1 = valStack.pop();
            int result = evaluateOperation(op, val1, val2);
            valStack.push(result);
        }

        return valStack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    private static int evaluateOperation(char op, int val1, int val2) {
        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else if (op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public static void main(String[] args) {
        String expression = "( ( 2 + 3 ) * ( 5 - 2 ) ) / 3";
        int result = evaluate(expression);
        System.out.println("Result of " + expression + " is " + result);
    }
}
