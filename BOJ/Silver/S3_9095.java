import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int t = 0; t < TC; t++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }

    // DP는 점화식을 세우자.
    // 1. N이 11이전까지이기 때문에 bruteforce를 배제
    // 2. N5까지의 숫자를 써본다.
    // 2-1. 1 2 4 7 13
    // 3. n이 4부터 n = n - 1 + n - 2 + n - 3의 점화식이 생긴다.
}
