import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long K;

    static boolean check(long mid) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, (int)(mid / i));
        }
        return cnt >= K;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Long.parseLong(br.readLine());

        long left = 1, right = (long) N * N, ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
