import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S5_1181 {
    public static List<String> words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if(words.contains(word)) continue;  // 있는 단어면 패스
            words.add(word);
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {    // 최초 정렬 조건 : 단어의 길이
                    return o1.length() - o2.length();
                } else {                            // 다음 정렬 조건 : 사전순
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
