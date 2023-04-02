import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ArrangeVer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine()); // số lượng test case
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            long[] a = new long[n];

            String[] line = reader.readLine().split(" ");
        }
    }

    // đã hoàn thành sắp xếp:
    public static int comp(long a, long b) {
        if (a == 2 && b == 3) {
            return 1; // tức định nghĩa 2 lớn 3
        } else if (a == 3 && b == 2) {
            return -1; // tức định nghĩa 3 nhỏ hơn 2
        } else {
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            else
                return 0;
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
            if (comp(lArray[i],rArray[j]) > 0) {
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
