import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class G4_7662 {
    public static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            map = new HashMap<>();

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());   // 큰 수 -> 작은 수
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();                            // 작은 수 -> 큰 수

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                String[] commands = br.readLine().split(" ");
                if (commands[0].equals("I")) {                      // 삽입
                    maxQueue.offer(Integer.parseInt(commands[1]));
                    minQueue.offer(Integer.parseInt(commands[1]));
                    map.put(Integer.parseInt(commands[1]), map.getOrDefault(Integer.parseInt(commands[1]), 0) + 1);
                } else {
                    if(map.size() == 0) continue;

                    if (commands[1].equals("1")) {                  // 큰 수 삭제
                        delete(maxQueue);
                    } else {                                        // 작은 수 삭제
                        delete(minQueue);
                    }
                }
            }

            if(map.size() == 0) {
                sb.append("EMPTY").append("\n");
            } else {
                int res = delete(maxQueue);
                sb.append(res).append(" ");
                if(map.size() > 0) res = delete(minQueue);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int delete(Queue<Integer> queue) {
        int res = 0;
        while(true) {       // 이미 지워진 수일수도 있으니 반복 처리
            res = queue.poll();

            int cnt = map.getOrDefault(res, 0);
            if(cnt == 0) continue;

            if(cnt == 1) map.remove(res);
            else map.put(res, cnt - 1);
            break;
        }

        return res;
    }
}
