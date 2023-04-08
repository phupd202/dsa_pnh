import java.util.Arrays;
import java.util.Scanner;

public class AdaAndFriend {

  public static void main(String[] args) {
    // Read input
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    int k = scan.nextInt();
    scan.nextLine();

    // Initialize arrays to store names and values
    String[] names = new String[q];
    long[] values = new long[q];

    int count = 0;
    boolean flag;
    // Read and store values
    for (int i = 0; i < q; i++) {
        String name = scan.next();
        long value = scan.nextLong();

        flag = false;
        for(int j = 0; j < count; j++) {
            if(names[j] == name) flag = true;
        }
        if(flag == false) {
            values[count] = value;
            names[count] = name;
            count++;
        } else {
            for (int j = 0; j < count; j++) {
                if(names[j] == name)  {
                    values[j] += value;
                }
            }
        }

        scan.nextLine();
    }
    scan.close();

    // Sort values in descending order
    Arrays.sort(values);

    // Compute the sum of the last k values
    long sum = 0;
    for (int i = 0; i < k; i++) {
        sum += values[count - 1 - i];
        
    }
    System.out.println(sum);
  }
}
