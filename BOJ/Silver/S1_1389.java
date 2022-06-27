import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1_1389 {
    public static int N, M, answer, minVal;
    public static int[][] matrix;
    public static class Relation {
        int index, value;

        public Relation(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        answer = 0;
        minVal = Integer.MAX_VALUE;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        matrix = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int[] relate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[relate[0]][relate[1]] = 1;
            matrix[relate[1]][relate[0]] = 1;
        }

        kevin();

        System.out.println(answer);
    }
    public static void kevin() {
        for (int i = 1; i < N + 1; i++) {
            boolean[] visit = new boolean[N + 1];
            Queue<Relation> queue = new LinkedList<>();

            queue.add(new Relation(i, 0));
            visit[i] = true;
            int values = 0;

            while(!queue.isEmpty()) {
                Relation current = queue.poll();

                for (int j = 1; j < N + 1; j++) {
                    if(matrix[current.index][j] == 1 && !visit[j]) {
                        queue.add(new Relation(j, current.value + 1));
                        visit[j] = true;
                        values += current.value + 1;
                    }
                }
            }

            if(minVal > values) {
                minVal = values;
                answer = i;
            }
        }
    }
}
