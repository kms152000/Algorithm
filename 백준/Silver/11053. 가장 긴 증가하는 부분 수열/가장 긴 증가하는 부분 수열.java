import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        int idx = 0;
        while (idx < N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && idx < N) {
                a[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        System.out.println(ans);
    }
}