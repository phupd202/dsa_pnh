package Hw4_20001958.stack;

public class MatchBracket {

    // Kiểm tra tính hợp lệ của biểu thức ngoặc đơn
    public static boolean checkMatch(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && (!stack.isEmpty())) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // infix to postfix
    public static String infixtoPosFix(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        String posfix = "";
        int n = s.length();
    
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {

                // xử lý toán hạng được nối liền nhau, chăng hạn 50 là 50 chứ ko phải 5 và 0
                if (i > 0 && Character.isDigit(s.charAt(i-1))) {
                    posfix += c;
                } else {
                    posfix += " " + c;
                }

            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    posfix += " " + stack.pop();
                }
                if (!stack.isEmpty() && stack.top() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.top())) {
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

    public static double calValue(String s) throws Exception {
        LinkedListStack<Double> stack = new LinkedListStack<>();
    
        // check invalid
        if (!checkMatch(s)) throw new Exception("Invalid expression");
    
        // convert infix to postfix
        String posfix[] = infixtoPosFix(s).split(" ");
    
        // tính giá trị của biêu thức hậu thứ tự
        int n = posfix.length;
        for (int i = 0; i < n; i++) {
            String c = posfix[i];
            if (c.equals("+")) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (c.equals("-")) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (c.equals("*")) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (c.equals("/")) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Double.parseDouble(c));
            }
        }
        return stack.pop();
    }
    

    public static void main(String[] args) throws Exception {
        // Biểu thức đầu vào không được chứa dấu cách, chỉ gồm các toán tử
        String s1 = "(1+(2+1)*(2*3))+(1+2)";  // = 22
        String s2 = "((50-((8-4)*(2+3)))+(3*4))"; // -3
        String s3 = "(1+((2+3)*(4*5)))";
        System.out.println(infixtoPosFix(s2));
        System.out.println("Giá trị của biểu thức (1+(2+1)*(2*3))+(1+2)) là: " + calValue(s1)); //đúng
        System.out.println("Giá trị của biểu thức ((50-((8-4)*(2+3)))+(3*4)) là: " + calValue(s2)); // đúng
        System.out.println("Giá trị của biểu thức  là: (1+((2+3)*(4*5)))" + calValue(s3)); // đúng
    }

}
