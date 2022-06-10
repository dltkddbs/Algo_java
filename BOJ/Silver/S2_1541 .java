import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S2_1541 {
    public static List<Integer> list;
    public static List<String> opList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String number = "";

        list = new ArrayList<>();
        opList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-' || input.charAt(i) == '+') {
                list.add(Integer.parseInt(number));
                number = "";
                opList.add(input.substring(i, i + 1));
            } else {
                number += input.charAt(i);
                if(i == input.length() - 1) {
                    list.add(Integer.parseInt(number));
                }
            }
        }

        calculate();
        System.out.println(result());
    }

    public static void calculate() {
        while(opList.contains("+")) {
            for (int i = 0; i < opList.size(); i++) {
                if(opList.get(i).equals("+")) {
                    opList.remove(i);
                    int new_val = list.get(i) + list.get(i + 1);
                    list.remove(i + 1);
                    list.remove(i);
                    list.add(i, new_val);
                    i--;
                }
            }
        }
    }

    public static int result() {
        if(list.size() == 1) {
            return list.get(0);
        } else {
            int sum = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                sum -= list.get(i);
            }
            return sum;
        }
    }
}

/*
int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

while (subtraction.hasMoreTokens()) {
	int temp = 0;

	// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
	StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

	// 덧셈으로 나뉜 토큰들을 모두 더한다.
	while (addition.hasMoreTokens()) {
		temp += Integer.parseInt(addition.nextToken());
	}

	// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
	if (sum == Integer.MAX_VALUE) {
		sum = temp;
	} else {
		sum -= temp;
	}
}
 */
