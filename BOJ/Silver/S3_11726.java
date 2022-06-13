import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 2];

        arr[1] = 1;
        arr[2] = 2;

        if(N >= 3) {
            for (int i = 3; i < N + 2; i++) {
                arr[i] = arr[i - 1] % 10007 + arr[i - 2] % 10007;
                arr[i] %= 10007;
            }
        }

        System.out.println(arr[N]);
    }
    // 단순히 도형을 그려도 n = n - 1 + n - 2를 알 수 있다.
    // 실제로 그 이유는
    // 맨 앞에 오는 모형이 | 일 때와 =일 때 두가지 경우로 나눌 수 있는데
    // 앞의 모양이 |면 n-1의 경우와 같고
    // 앞의 모양이 =면 n-2와 같은 경우이기 때문에 그렇다는 것을 알 수 있다.
}
