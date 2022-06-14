import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_1931 {
    public static class Time implements Comparable<Time> {
        int start_time;
        int end_time;

        public Time(int start_time, int end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
        }

        @Override
        public int compareTo(Time time) {
            if(this.end_time == time.end_time) {
                return this.start_time - time.start_time;
            } else {
                return this.end_time - time.end_time;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Time[] timeTable = new Time[N];
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Time time = new Time(input[0], input[1]);

            timeTable[i] = time;
        }

        Arrays.sort(timeTable);

        int conference = 1;
        int curTime = timeTable[0].end_time;

        for (int i = 1; i < N; i++) {
            if (curTime <= timeTable[i].start_time) {
                conference++;
                curTime = timeTable[i].end_time;
            }
        }

        System.out.println(conference);
    }
}
