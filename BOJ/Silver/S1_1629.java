import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(conquer_pow(inputs[0], inputs[1]));
    }
    public static long conquer_pow(int number, int n) {
        if(n == 1) return number % inputs[2];
        else {
            long new_num = conquer_pow(number, n / 2) % inputs[2];

            if(n % 2 == 0) {
                return new_num % inputs[2] * new_num % inputs[2];
            } else {
                return new_num % inputs[2] * new_num % inputs[2] * number % inputs[2];
            }
        }
    }
}
