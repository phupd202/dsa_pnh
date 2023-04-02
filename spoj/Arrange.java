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
            Arrays.sort(a);
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
}