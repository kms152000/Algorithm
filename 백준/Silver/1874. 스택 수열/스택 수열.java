import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1; // 다음에 push할 숫자
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int target = seq[i];

            // target까지 push
            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }

            // pop 검사
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            bw.write(sb.toString());
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
