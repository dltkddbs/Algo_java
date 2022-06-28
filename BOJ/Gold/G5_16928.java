import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_16928 {
    public static int N, M, answer;
    public static int[] map;
    public static boolean[] visit;
    public static class Dice {
        int loc, value;

        public Dice(int loc, int value) {
            this.loc = loc;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new int[101];
        visit = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        BFS();
        System.out.println(answer);
    }
    public static void BFS() {
        Queue<Dice> queue = new LinkedList<>();
        queue.offer(new Dice(1, 0));

        while(!queue.isEmpty()) {
            Dice dice = queue.poll();

            for (int i = 1; i < 7; i++) {
                int newLoc = dice.loc + i;

                if(visit[newLoc]) continue;

                if(newLoc == 100) {
                    answer = dice.value + 1;
                    return;
                }

                visit[newLoc] = true;
                if (map[newLoc] == 0) { // 뱀 혹은 사다리가 있는 경우
                    queue.add(new Dice(newLoc, dice.value + 1));
                } else {                // 그 외의 경우 그냥 전진
                    queue.add(new Dice(map[newLoc], dice.value + 1));
                }
            }
        }
    }
}
