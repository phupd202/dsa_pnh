package Hw4_20001958.stack;

import java.util.Stack;

public class MatchBracket {

    // Kiểm tra tính hợp lệ của biểu thức ngoặc đơn
    public static boolean checkMatch(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        // Stack<Character> stack = new Stack<Character>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // Tính giá trị của biểu thức nếu biểu thức hợp lệ về ngoặc
    public static String calValue(String s) {
        // LinkedListStack<String> stack = new LinkedListStack<String>();
        Stack<String> stack = new Stack<String>();
        int n = s.length();

        if (!checkMatch(s)) {
            return "Invalid expression";
        } //true

        for (int i = 0; i < n; i++) {
            String ch = Character.toString(s.charAt(i));

            // nếu gặp ngoặc đóng thì pop 2 toán hạng và toán tử, tính gia trị biểu thức rồi push lại
            if(ch.equals(")")){
                try {
                    double num = Double.parseDouble(stack.pop());
                    String operator = stack.pop();
                    double preNum = Double.parseDouble(stack.pop());

                    switch (operator) {
                        case "+":
                            stack.push(Double.toString(preNum + num));
                            break;
                        case "-":
                            stack.push(Double.toString(preNum - num));
                            break;
                        case "*":
                            stack.push(Double.toString(preNum * num));
                            break;
                        case "/":
                            stack.push(Double.toString(preNum / num));
                            break;
                        default:
                            return "Invalid operator";
                    }
                } catch (Exception e) {
                    return "Invalid";
                }
            } 
            // nếu gặp toán tử, tử hàng, mở ngoaiwj thi push vào
            else {
                stack.push(ch);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "(1+(2+1)*(2*3))";
        System.out.println(checkMatch(s));
        System.out.println(calValue(s)); // expects 19.0
    }

}
