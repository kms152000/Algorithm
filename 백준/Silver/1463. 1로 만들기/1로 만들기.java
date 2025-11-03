import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            int min = dp[i - 1] + 1;
            if (i % 2 == 0){
                min = Math.min(min, dp[i / 2] + 1);   
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }
            dp[i] = min;
        }
        
        System.out.println(dp[n]);
    }
}