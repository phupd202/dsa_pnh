package hw3_20001958.exercise_1;

import java.util.Scanner;

public class TestComplex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số phức: ");
        int n = sc.nextInt();

        // Lưu các số phức nhập vào vào mảng
        Complex complexs[] = new Complex[n];

        // Enter the complex
        for (int i = 0; i < complexs.length; i++) {
            System.out.println("Nhập vào phần thực: ");
            float real = sc.nextFloat();
            System.out.println("Nhâp vào phần ảo: ");
            float image = sc.nextFloat();

            complexs[i] = new Complex(real, image); 
        }


        // In ra phần tử thứ v trong dãy
        System.out.println("Nhập phần tử muốn in: ");
        int v = sc.nextInt();
        System.out.println(complexs[v].toString());

        // Cộng nhiều số phức 
        float sumReal = 0;
        float sumImage = 0;
        for (int i = 0; i < complexs.length; i++) {
            sumReal += complexs[i].realpart();
            sumImage += complexs[i].imagepart();
        }

        Complex result = new Complex(sumReal, sumImage);

        System.out.println("Tống của dãy số phức vừa nhập: ");
        System.out.println(result.toString());
    }   


}
