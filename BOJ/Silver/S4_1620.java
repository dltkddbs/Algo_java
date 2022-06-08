import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class S4_1620 {
    public static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Integer> alphaToInt = new HashMap<>();  // 알파벳 -> 숫자
        HashMap<Integer, String> intToAlpha = new HashMap<>();  // 숫자 -> 알파벳

        for (int i = 0; i < inputs[0]; i++) {   // 도감에 포켓몬 추가
            String pocketmon = br.readLine();

            alphaToInt.put(pocketmon, i + 1);
            intToAlpha.put(i + 1, pocketmon);
        }

        for (int i = 0; i < inputs[1]; i++) {   
            String question = br.readLine();

            if(Character.isDigit(question.charAt(0))) { // 입력 받은 값이 숫자면 
                int value = Integer.parseInt(question);
                System.out.println(intToAlpha.get(value));  // 숫자로 알파벳 조회
            } else {
                System.out.println(alphaToInt.get(question));   // 그 외에는 알파벳으로 숫자 조회
            }
        }
    }
}
