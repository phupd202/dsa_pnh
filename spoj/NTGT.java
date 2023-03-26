package spoj;

import java.util.*;
import java.lang.*;

/*
 * Số nguyên tố giai thừa
 */

public class NTGT {

    // check prime factorial
    public static boolean checkFact(int n) {

        if(n < 1) return false;

        // check Factorial Prime với input là số nguyên tố
        int factorial = 1;
        int coef = 2;

        while(factorial < n- 1) {
            factorial = factorial * coef;
            coef++;
        }

        if(factorial == n - 1 || factorial == n || factorial == n + 1) {
            return true;
        } else {
            return false;
        }
    }

    // main
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
                
            if(checkFact(input)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }
    }
}
