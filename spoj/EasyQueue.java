import java.util.*;
import java.lang.*;

public class EasyQueue {
    public static void main(String[] args) throws java.lang.Exception{

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        // input
        int[] queue = new int[t];
        int front = 0;
        int rear = -1;

        String[] result = new String[100000];
        int count = 0;

        for (int i = 0; i < t; i++) {
            String s[] = sc.nextLine().split(" ");

            if (s[0].equals("1")) {
                queue[++rear] = Integer.parseInt(s[1]);
            } else if (s[0].equals("2")) {
                if (front <= rear) {
                    front++;
                }
            } else if (s[0].equals("3")) {
                if (front > rear) {
                    result[count++] = "Empty!";
                } else {
                    result[count++] = String.valueOf(queue[front]);
                }
            }            
        }

        // in kết quả
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
            
        }

    }
}
