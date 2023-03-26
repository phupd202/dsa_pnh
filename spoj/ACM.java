package spoj;

import java.util.*;
import java.lang.*;

class ACM {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);

        int nTest = sc.nextInt(); // số lượng mẫu 
        int result; // lưu trứ ouput

        // nhập data
        for (int i = 0; i < nTest; i++) {
            int nSample = sc.nextInt();

            // Nhập cân nặng
            int n = nSample + 2;
            int[] data = new int[n];

            data[0] = nSample;// phần tử đầu tiên của mang lưu số lượng các thành viên của đội
            for (int j = 1; j < n - 1; j++) {
                data[j] = sc.nextInt();
            }
            data[n - 1] = sc.nextInt();// phần tử cuối cùng lưu ngướng cân nặng dành cho đội

            //find max 
            int output = checkMax(data);
            System.out.println(output);

        }

    }     

    // checkMax
    public static int checkMax(int[] data) {

        int n = data.length;
        int overWeight = data[n - 1];
        int max = 0;
    
        for (int i = 1; i < n - 1; i++) { // bỏ qua phân tử dầu và cuối
           for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n - 1; k++) { 
                   
                    int sum = data[i] + data[j] + data[k];
                    if (sum > max && sum <= overWeight) max = sum;
                }
           }
        }

        return max; 
    }
}
        


