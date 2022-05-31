import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2577 {
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = new int[10];

        int multi = 1;

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(br.readLine());
            multi *= number;
        }

        String number = String.valueOf(multi);
        for (int i = 0; i < number.length(); i++) {
            result[number.charAt(i) - '0']++;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
