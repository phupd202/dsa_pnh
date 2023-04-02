import java.util.Scanner;

public class InversionCount {

    public static long solve(int[] array, int n) throws Exception {
        if (n == 1)
            return 0;

        // Chia mảng thành 2 phần
        int m = (n - 1) / 2;
        int n1 = m + 1;
        int n2 = n - 1 - m;

        // copy to 2 sub array
        int[] lArray = new int[n1];
        for (int i = 0; i < n1; i++)
            lArray[i] = array[i];
        int[] rArray = new int[n2];
        for (int i = 0; i < n2; i++)
            rArray[i] = array[m + 1 + i];

        // Add the number of inversions in each half
        long inversions = solve(lArray, n1) + solve(rArray, n2);

        // Merge and cal num inversion
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                array[k++] = lArray[i++];
            } else {
                array[k++] = rArray[j++];
                inversions += n1 - i; // found more inversions
            }
        }
        while (i < n1)
            array[k++] = lArray[i++];
        while (j < n2)
            array[k++] = rArray[j++];
        return inversions;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next()); // số lượng test case

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.next());
            int[] arr = new int[n];

            // Đọc các phần tử của mảng
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(sc.next());
            }
            System.out.println(solve(arr, n));
        }
    }

}