class Solution {
    public int solution(int n) {
        final int MOD = 1234567;
        
        int prev2 = 0;
        int prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int cur = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}