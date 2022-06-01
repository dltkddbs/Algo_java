import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(melody());
    }
    public static String melody() {
        int flag = 0;
        int before = inputs[0];
        int current = 0;

        for(int i = 1; i < inputs.length; i++) {
            current = inputs[i];

            if(flag == 0) {
                if(current - before > 0) {
                    flag = 1;
                } else {
                    flag = -1;
                }
            } else {
                if(flag == 1 && current - before < 0) { // 기존에 오름차순이었는데 달라진 경우
                    return "mixed";
                }
                if(flag == -1 && current - before > 0) {
                    return "mixed";
                }
            }
            before = inputs[i];
        }

        return flag == 1 ? "ascending" : "descending";
    }
}
