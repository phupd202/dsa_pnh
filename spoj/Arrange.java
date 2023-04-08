import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * a > b thì a^b > b^a
 * Th ngoại lệ:
 * Nếu a = 2, b = 3 thì kq là 2 và 3
 * TH đặc biệt:
 * Nếu input = 1 thì 1 phải la số đầu tiên
 * Idea: sắp xếp mảng
 */
public class Arrange {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine()); // số lượng test case
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            long[] a = new long[n];

            String[] line = reader.readLine().split(" ");

            // Số 1 phải được lên trước
            for (int j = 0; j < n; j++) {
                a[j] = Long.parseLong(line[j]);
                if (a[j] == 1) {
                    sb.append("1 ");
                }
            }
            mergeSort(a, 0, n - 1);
            // nếu số 2 và 3 liên tiếp nhau, output = số 2 rồi đên số 3
            if (n >= 2 && a[n - 1] == 3 && a[n - 2] == 2) {
                sb.append("2 3 ");
                for (int j = n - 3; j >= 0; j--) {
                    if (a[j] == 1) {
                        break;
                    }
                    sb.append(a[j]).append(" ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (a[j] == 1) {
                        break;
                    }
                    sb.append(a[j]).append(" ");
                }
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
            if (lArray[i] <= rArray[j]) {
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