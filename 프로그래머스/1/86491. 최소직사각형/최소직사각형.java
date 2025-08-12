class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;
        
        for (int[] s : sizes) {
            int w = Math.max(s[0], s[1]);
            int h = Math.min(s[0], s[1]);
            if (w > maxW) maxW = w;
            if (h > maxH) maxH = h;
        }
        
        return maxW * maxH;
    }
}
