import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S2_11724 {
    public static int N, M, answer;
    public static boolean[] visit;
    public static ArrayList[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] condition = br.readLine().split(" ");

        N = Integer.parseInt(condition[0]);
        M = Integer.parseInt(condition[1]);

        answer = 0;
        visit = new boolean[N + 1];
        arrayLists = new ArrayList[N + 1];

        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 인접 정보 저장
            arrayLists[inputs[0]].add(inputs[1]);
            arrayLists[inputs[1]].add(inputs[0]);
        }
        BFS();

        System.out.println(answer);
    }

    // BFS로 탐색
    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            // KEY 포인트 : input에 간선으로 명시되지 않은 노드도 단독 노드로 판단하여 체크해야함
            if(!visit[i]) { // 방문하지 않은 노드인 경우 체크
                queue.add(i);
                visit[i] = true;
                answer++;
            }

            // 해당 노드와 연결된 모든 노드 탐색
            while(!queue.isEmpty()) {
                int node = queue.poll();

                for (int j = 0; j < arrayLists[node].size(); j++) {
                    if(!visit[(int) arrayLists[node].get(j)]) {
                        queue.add((int) arrayLists[node].get(j));
                        visit[(int) arrayLists[node].get(j)] = true;
                    }
                }
            }
        }
    }
}
