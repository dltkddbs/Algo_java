import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class S3_1966 {
    public static class Print {
        int index, lv;

        public Print(int index, int lv) {
            this.index = index;
            this.lv = lv;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            Queue<Print> queue = new LinkedList<>();
            PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);

            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] prints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < prints.length; i++) {
                queue.add(new Print(i, prints[i]));
                pQueue.add(prints[i]);
            }

            int count = 0;

            while(true) {
                Print print = queue.poll();
                if(print.lv == pQueue.peek()) {     // 가장 우선순위가 높은 문서인지 체크
                    count++;
                    pQueue.poll();
                    if(print.index == inputs[1]) {  // 목표 문서면 출력 후 종료
                        sb.append(count).append("\n");
                        break;
                    }
                } else {                            // 우선순위가 낮은 문서면 뒤로 보내기기
                    queue.add(print);
                }
            }
        }

        System.out.println(sb);
    }
}
