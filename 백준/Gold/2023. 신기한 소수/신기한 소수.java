import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static BufferedWriter bw;

    static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        int r = (int)Math.sqrt(x);
        for (int i = 3; i <= r; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static void dfs(int num, int len) throws IOException {
        if (len == N) {
            bw.write(Integer.toString(num));
            bw.newLine();
            return;
        }
        // 마지막 자리는 홀수만 (1,3,7,9) 시도
        int[] cand = {1, 3, 7, 9};
        for (int d : cand) {
            int next = num * 10 + d;
            if (isPrime(next)) dfs(next, len + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine().trim());

        int[] starts = {2, 3, 5, 7};
        for (int s : starts) dfs(s, 1);

        bw.flush();
        bw.close();
        br.close();
    }
}
