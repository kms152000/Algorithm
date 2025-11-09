import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] queries = new int[T];
        int maxN = 0;

        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine().trim());
            if (queries[i] > maxN) maxN = queries[i];
        }

        int[] dp = new int[Math.max(4, maxN + 1)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int n = 4; n <= maxN; n++) {
            dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
        }


        for (int n : queries) {
            bw.write(Integer.toString(dp[n]));
            bw.newLine();
        }


        bw.flush();
        br.close();
        bw.close();
    }
}