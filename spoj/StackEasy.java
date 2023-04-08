
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * BufferedOutputStream giúp tăng hiệu suất của chương trình bằng cách đệm các dữ liệu trước khi ghi vào output stream, giúp giảm số lần ghi dữ liệu và tăng tốc độ ghi dữ liệu.
 * BufferedOutputStream giúp tránh tình trạng tràn bộ đệm (buffer overflow) do việc ghi dữ liệu quá nhanh
 * Sử dụng phương thức write(byte[] b) để ghi dữ liệu kiểu byte vào đối tượng BufferedOutputStream. 
 * Sử dụng getbyte() để lấy kiểu byte của String
 * Sử dụng BufferedOutputStream sẽ nhanh hơn.
 */

 public class StackEasy {

    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      BufferedOutputStream bos = new BufferedOutputStream(System.out);
      int t = Integer.parseInt(sc.nextLine()); // số lượng test case
      
      // Cài stack băng mảng
      int[] stack = new int[t];
      int count = 0;
      for (int i = 0; i < t; i++) {
        String s = sc.nextLine();
        if (s.charAt(0) == '1') {
          stack[count++] = Integer.parseInt(s.substring(2));
        } else if (s.equals("2")) {
          if (count >= 1) {
            count--;
          }
        } else if (s.equals("3")) {
          bos.write((count == 0 ? "Empty!\n" : stack[count - 1] + "\n").getBytes());
        }
      }
      bos.flush();
    }
  }