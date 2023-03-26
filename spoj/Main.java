package spoj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
                
            if(isFibonaci(input)) {
                System.out.print("YES");
            }
            else {
                System.out.print("NO");
            }
            System.out.println();

        }
    }

    // check Fibonaci
    public static boolean isFibonaci(int n) {
        if(n < 1) return false;
        
        int f0 = 1;
        int f1 = 1;
        int f2;

        do {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        } while (f2 < n);

        if(f2 == n) {
            return true;
        } else {
            return false;
        }
   }
}