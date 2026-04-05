class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        long gcd = gcd(W, H);
        
        return W * H - (W + H - gcd);
    }
    
    private long gcd(long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        
        return x;
    }
}