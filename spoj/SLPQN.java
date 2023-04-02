
import java.util.Scanner;

public class SLPQN {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            System.out.println(printCube(input));
            

        }
    }

    // check lập phương
    private static int printCube(int input) {
        int max = 1;
        int result = 1;

        int cube = 1;
        for (int i = 1; i < input; i++) {
            cube = i * i * i;

            if(cube > max && cube <= input) {
                max = cube;
                result = i;
            }
            
        }

        return result;
    }
}
