import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_1107 {
    public static int channel, N, answer;
    public static int[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        channel = Integer.parseInt(br.readLine());
        answer = Math.abs(channel - 100);
        N = Integer.parseInt(br.readLine());
        
        if(N == 0) {
            answer = Math.min(answer, String.valueOf(channel).length());
        } else {
            broken = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
            xx:for (int i = 0; i < 1000000; i++) {
                String curChannel = String.valueOf(i);
                for (int j = 0; j < broken.length; j++) {
                    if(curChannel.contains(String.valueOf(broken[j]))) {
                        continue xx;
                    }
                }
    
                answer = Math.min(answer, curChannel.length() + Math.abs(channel - i));
            }
        }

        System.out.println(answer);
    }
}
