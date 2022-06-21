import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G5_7569 {
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int N, M, K, answer;
    public static int[][][] matrix;
    public static Queue<Tomato> tomatoes;
    public static class Tomato {
        int x, y, z, days;

        public Tomato(int x, int y, int z, int days) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.days = days;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        answer = 0;
        matrix = new int[N][M][K];
        tomatoes = new LinkedList<>();

        for (int i = 0; i < M * K; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < inputs.length; j++) {
                matrix[j][i % M][i / M] = inputs[j];
                if(inputs[j] == 1) tomatoes.add(new Tomato(j, i % M, i / M, 0));
            }
        }

        BFS();
        if(!zeroCheck()) answer = -1;
        System.out.println(answer);
    }
    public static void BFS() {
        while(!tomatoes.isEmpty()) {
            Tomato tomato = tomatoes.poll();

            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < K) {   // 범위 체크
                    if(matrix[nx][ny][nz] == 0) {   // 안 익은 토마토인지 체크
                        matrix[nx][ny][nz] = 1;
                        tomatoes.add(new Tomato(nx, ny, nz, tomato.days + 1));
                        answer = Math.max(tomato.days + 1, answer);
                    }
                }
            }
        }
    }
    // 안익은 토마토가 있는지 체크
    public static boolean zeroCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    if(matrix[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }
}
