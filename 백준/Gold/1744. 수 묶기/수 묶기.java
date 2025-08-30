import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Integer> pos = new ArrayList<>();  // > 1
        List<Integer> neg = new ArrayList<>();  // <= -1
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x > 1) pos.add(x);
            else if (x == 1) ones++;
            else if (x == 0) zeros++;
            else neg.add(x);
        }

        Collections.sort(pos, Collections.reverseOrder()); // 큰 수끼리 곱
        Collections.sort(neg); // 작은(음수 절댓값 큰) 것부터 곱

        long sum = 0;

        // 양수(>1) 묶기
        for (int i = 0; i + 1 < pos.size(); i += 2) {
            sum += (long) pos.get(i) * pos.get(i + 1);
        }
        if (pos.size() % 2 == 1) sum += pos.get(pos.size() - 1);

        // 음수 묶기
        for (int i = 0; i + 1 < neg.size(); i += 2) {
            sum += (long) neg.get(i) * neg.get(i + 1);
        }
        if (neg.size() % 2 == 1) {
            // 남은 음수 하나: 0이 있으면 0과 묶어 버림(효과 0), 없으면 더함
            if (zeros == 0) sum += neg.get(neg.size() - 1);
        }

        // 1은 무조건 더하는 게 이득
        sum += ones;

        System.out.println(sum);
    }
}
