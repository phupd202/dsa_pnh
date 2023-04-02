import java.util.*;

public class Arrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Nhập input
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
            }
            // quick sort
            quickSort(input, 0, n - 1);

            int j = 0;
            while(input[j] == 1){
                System.out.print("1 ");
                j++;
            }
		
            if(j == n-2 && input[j] == 2 && input[j+1] == 3)
                System.out.print("2 3");
            else{
                for(int k=n-1;k>=j;k--) {
                    System.out.print(input[k] + " ");
                }
            }
		
		System.out.println();
            
        }


        
    }

    // partition
    public static int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int j = r + 1;
        int pivot = arr[l];
    
        while (true) {
            while (arr[++i] < pivot); // đi từ bên trái sang nếu nhỏ hơn pivot thì tiếp tực
            while (arr[--j] > pivot); // đi từ bên trái sang nếu lớn hợn pivot thì tiếp tục
    
            if (i >= j) {
                return j;
            }  
             // Nếu tìm được vị trí thì tráo
             swap(arr, i, j);
            
        }
    }
    // swap
    public static void swap(int matrix[], int i, int j) {
        int temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    // quick sort
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int partition = partition(arr, l, r);
            quickSort(arr, l, partition);
            quickSort(arr, partition + 1, r);
        }
    }
}
