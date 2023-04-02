
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //cài queue = mảng
        int[] queue = new int[t];
        int front = 0;
        int rear = -1;

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if (s.charAt(0) == '1') {
                queue[++rear] = Integer.parseInt(s.substring(2));
            } else if (s.equals("2")) {
                if (front <= rear) {
                    front++;
                }
            } else if (s.equals("3")) {
                if(front > rear) System.out.println("Empty!\n");
                else System.out.println(queue[front] + "\n");
            }
        }
    }
}