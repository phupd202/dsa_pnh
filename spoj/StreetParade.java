import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            // Mảng a chứa thứ tự các xe
            int[] cars = new int[n];
            for (int i = 0; i < n; i++) {
                cars[i] = sc.nextInt();
            }


			// Push từng phần tử vào stack, kiểm tra thứ tự
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int car : cars) {
                stack.push(car);
                // Nếu stack chưa rống, kiểm tra phần tử đầu tiên của stack có bằng i + 1 ko, nếu có, i++
                while (!stack.empty() && stack.peek() == i + 1) {
                    stack.pop();
                    i++;
                }
            }

            if(stack.empty()) System.out.println("yes");
            else System.out.println("no");
        }

        sc.close();
    }
}
