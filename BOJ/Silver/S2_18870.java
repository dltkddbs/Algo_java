import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_18870 {
    public static class Point {
        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static List<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int[] points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            list.add(new Point(points[i], i));
        }

        // value를 기준으로 최초 정렬
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });
        flatten();

        for (Point point : list) {
            sb.append(point.value).append(" ");
        }
        System.out.println(sb);
    }
    public static void flatten() {
        int start = 0;  // 가장 작은 값을 0으로 시작
        int curVal = list.get(0).value;

        list.set(0, new Point(start, list.get(0).index));

        for (int i = 1; i < list.size(); i++) {
            // 다음 값이 기존 값보다 크면 1씩 증가시켜가며 값을 변경
            if(list.get(i).value != curVal) {
                curVal = list.get(i).value;
                start++;
            }
            list.set(i, new Point(start, list.get(i).index));
        }

        // 인덱스를 기준으로 재정렬렬
       Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.index - o2.index;
            }
        });
    }
}
