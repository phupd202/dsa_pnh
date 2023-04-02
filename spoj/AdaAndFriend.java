import java.util.*;
import java.lang.*;

public class AdaAndFriend {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next()); // số ngày lễ
        int k = Integer.parseInt(sc.next()); // số lượng bạn tối đa muốn huỷ
        sc.nextLine();

        int[] expenses = new int[n];
        String[] names = new String[n];

        int count = 0;
        for (int j = 0; j < n; j++) {
            String[] tokens = sc.nextLine().split(" ");
            String name = tokens[0];
            int expense = Integer.parseInt(tokens[1]);

            int index = getIndex(names, name, count);
            if(index >= 0) {
                expenses[index] += expense;
            } else {
                expenses[count] = expense;
                names[count] = name;
                count++;
            }
        }
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(expenses));

        quickSort(expenses, 0, count - 1);

        long totalValue = 0;
        for (int i = 0; i < k; i++) {
            totalValue += expenses[count - 1 - i];
        }
        System.out.println(totalValue);
        sc.close();
    }

    // partition
    public static int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int j = r + 1;
        int pivot = arr[l];

        while (true) {
            while (arr[++i] < pivot); // đi từ bên trái sang nếu nhỏ hơn pivot thì tiếp tục
            while (arr[--j] > pivot); // đi từ bên trái sang nếu lớn hơn pivot thì tiếp tục

            if (i >= j) {
                return j;
            }
            // Nếu tìm được vị trí thì tráo
            swap(arr, i, j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int partition = partition(arr, l, r);
            quickSort(arr, l, partition);
            quickSort(arr, partition + 1, r);
        }
    }

    public static int getIndex(String[] names, String word, int count) {
        for (int i = 0; i < count; i++) {
            if(names[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
// Chưa sub được
