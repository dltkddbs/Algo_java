import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "add":
                    list.add(Integer.valueOf(command[1]));
                    break;
                case "check":
                    if (list.contains(Integer.valueOf(command[1]))) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "remove" :
                    if(list.contains(Integer.valueOf(command[1]))) {
                        list.remove(Integer.valueOf(command[1]));
                    }
                    break;
                case "toggle" :
                    if (list.contains(Integer.valueOf(command[1]))) {
                        list.remove(Integer.valueOf(command[1]));
                    } else {
                        list.add(Integer.valueOf(command[1]));
                    }
                    break;
                case "all" :
                    list = new ArrayList<>();
                    for (int j = 1; j < 21; j++) {
                        list.add(j);
                    }
                    break;
                case "empty" :
                    list = new ArrayList<>();
                    break;
            }
        }

        System.out.println(sb);
    }
}
