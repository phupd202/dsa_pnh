package Hw4_20001958_PhamDuyPhu.queue;

import java.util.Scanner;

import Hw4_20001958_PhamDuyPhu.stack.LinkedListStack;

public class Palinedrome {
    public static boolean checkPalinedrome(String s) {
        int mid = s.length() / 2;
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        LinkedListQueue<Character> queue = new LinkedListQueue<Character>();

        // push to stack, queue
        for (int i = 0; i < mid; i++) {
            queue.enqueue(s.charAt(i));
        }
        

        for (int i = mid; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }


        // check palinedrome
        for (int i = 0; i < mid; i++) {
            Character first = queue.dequeue();
            Character last = stack.pop();
            
            if(!first.equals(last)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập string cần kiểm tra palinedrome: ");
        String s = sc.nextLine();
        System.out.println(checkPalinedrome(s));

        



    }
}
