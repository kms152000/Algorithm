import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);

        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == -1) continue;

            if (i + n <= y) {
                if (dp[i + n] == -1 || dp[i + n] > dp[i] + 1) {
                    dp[i + n] = dp[i] + 1;
                }
            }

            if (i * 2 <= y) {
                if (dp[i * 2] == -1 || dp[i * 2] > dp[i] + 1) {
                    dp[i * 2] = dp[i] + 1;
                }
            }

            if (i * 3 <= y) {
                if (dp[i * 3] == -1 || dp[i * 3] > dp[i] + 1) {
                    dp[i * 3] = dp[i] + 1;
                }
            }
        }

        return dp[y];
    }
}