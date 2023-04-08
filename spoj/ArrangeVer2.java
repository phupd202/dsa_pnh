/*
 * Ý tưởng: 
 * Sắp xếp dãy tăng dần
 * Nếu input = 1, 1 phải đứng đầu tiên ở output
 * Đối với trường hợp số 2 và 3 liên tiếp nhau, viết hàm comp định nghĩa số 2 > số 3, để việc sắp xếp dễ dàng hơn
 * Output: Kết quả đúng, but chưa sub được
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrangeVer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine()); // số lượng test case
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();
            long[] a = new long[n];
            String[] line = reader.readLine().split(" ");
            int count = 0;

            for (int j = 0; j < n; j++) {
                long num = Long.parseLong(line[j]);


                // nếu bằng 1 cho vào kết quả, nếu không thì cho vào 1 mảng và sắp xếp mảng đó
                if(num == 1) {
                    sb.append("1 ");
                } else {
                    a[count++] = num;
                }
            }
            mergeSort(a, 0, count - 1);

            // nối các phần tử trong mảng với sb, để có dạng 1 + dãy số tăng dần
            for (int j = 0; j < count; j++) {
                sb.append(a[j]).append(" ");
            }

            System.out.println(sb);

        }

    }

    // merge 2 array
    public static void merge(long[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // copy to 2 subarray
        long[] lArray = new long[n1];
        long[] rArray = new long[n2];

        for (int i = 0; i < n1; ++i) {
            lArray[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            rArray[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        // merge
        while (i < n1 && j < n2) {
            if (lArray[i] >= rArray[j]) {
                arr[k++] = lArray[i++];
            } else {
                arr[k++] = rArray[j++];
            }
        }

        // khi không còn các cặp để so sánh, copy các phần tử còn lại
        while (i < n1) {
            arr[k++] = lArray[i++];
        }

        while (j < n2) {
            arr[k++] = rArray[j++];
        }
    }

    // sort
    public static void mergeSort(long[] array, int l, int r) {
        int m = l + (r - l) / 2;
        if (l < r) {
            // mergesort
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }

    }

}
