import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < 10; t++) {
            System.out.println(TC + " * " + t + " = "  + TC * t);
        }
    }
}
