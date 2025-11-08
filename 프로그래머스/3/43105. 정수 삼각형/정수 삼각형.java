class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];
        dp[0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int left = (j > 0) ? dp[j - 1] : 0;
                int right = (j < i) ? dp[j] : 0;
                dp[j] = Math.max(left, right) + triangle[i][j];
            }
        }
        
        
        int ans = 0;
        
        for (int v : dp) {
            ans = Math.max(ans, v);
        }
        
        return ans;
    }
}