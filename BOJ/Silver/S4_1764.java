import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class S4_1764 {
    public static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < inputs[0] + inputs[1]; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {     // 듣지도 보지도 못했으면 추가
                map.put(name, map.get(name) + 1);
                count++;
            } else {
                map.put(name, 1);
            }
        }

        // hashmap을 key를 통해 정렬
        Object[] keySets = map.keySet().toArray();
        Arrays.sort(keySets);

        System.out.println(count);
        for (Object key : keySets) {
            if(map.get(key) > 1) {
                System.out.println(key);
            }
        }
    }
}
