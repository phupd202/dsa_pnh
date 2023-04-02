package test;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n;
    Stack<Integer> stack = new Stack<>();
    int nextTruck;
    int nextExpectedTruck;

    while (true) {
      nextExpectedTruck = 1;
      n = scanner.nextInt();

      if (n == 0) {
        break;
      }

      while (n > 0) {
        if (!stack.isEmpty() && stack.peek() == nextExpectedTruck) {
          stack.pop();
          nextExpectedTruck++;
          continue;
        }

        nextTruck = scanner.nextInt();
        if (nextTruck == nextExpectedTruck) {
          nextExpectedTruck++;
        } else {
          stack.push(nextTruck);
        }

        n--;
      }
      while (!stack.isEmpty() && stack.peek() == nextExpectedTruck) {
        stack.pop();
        nextExpectedTruck++;
      }

      if (stack.isEmpty()) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }

    }
  }
}