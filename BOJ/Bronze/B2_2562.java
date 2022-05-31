import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2562 {
    public static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = new int[9];
        int max = 0;
        int max_idx = 0;

        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            inputs[i] = input;

            if (max < input) {
                max = input;
                max_idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(max_idx);
    }
}
