import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            String input = br.readLine();

            System.out.println(cal_score(input));
        }

    }
    public static int cal_score(String input) {
        int score = 0;
        int current = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'O') {
                current++;
                score += current;
            } else {
                current = 0;
            }
        }

        return score;
    }
}
