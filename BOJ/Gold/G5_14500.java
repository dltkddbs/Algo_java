import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_14500 {
    public static int N, M, answer;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] matrix;
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][M];  // 방문배열 초기화를 for문 안에서 하면 시간초과가 발생한다 => 매번 N X M번 돌기 때문
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                DFS(i, j, matrix[i][j], 1);
                visit[i][j] = false;
                answer = Math.max(answer, block(i, j));
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int r, int c, int value, int move) {
        if(move == 4) {
            answer = Math.max(answer, value);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if(visit[nr][nc]) continue;
                    visit[nr][nc] = true;
                    DFS(nr, nc, value + matrix[nr][nc], move + 1);
                    visit[nr][nc] = false;
                }
            }
        }
    }
    public static int block(int r, int c) { // 특이한 모양은 따로 체크
        int result = 0;

        if(r < N - 1 && c > 0 && c < M - 1) {   // ㅗ 모양
            result = Math.max(result, matrix[r][c] + matrix[r + 1][c - 1] + matrix[r + 1][c] + matrix[r + 1][c + 1]);
        }
        if(r < N - 2 && c < M - 1) {   // ㅏ 모양
            result = Math.max(result, matrix[r][c] + matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 2][c]);
        }
        if(r < N - 2 && c > 0) {   // ㅓ 모양
            result = Math.max(result, matrix[r][c] + matrix[r + 1][c] + matrix[r + 1][c - 1] + matrix[r + 2][c]);
        }
        if(r < N - 1 && c < M - 2) {   // ㅜ 모양
            result = Math.max(result, matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c + 1] + matrix[r][c + 2]);
        }

        return result;
    }
}
