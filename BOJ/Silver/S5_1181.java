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

        Collections.sort(words, (a, b) -> (a.length == b.length) ? a.compareTo(b) : a.length - b.length });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
