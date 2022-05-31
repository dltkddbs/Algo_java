import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            String[] inputs = br.readLine().split(" ");

            int repeat = Integer.parseInt(inputs[0]);

            String result = "";
            for (int i = 0; i < inputs[1].length(); i++) {
                for (int j = 0; j < repeat; j++) {
                    result += inputs[1].charAt(i);
                }
            }

            System.out.println(result);
        }
    }
}
