class Solution {
    public String solution(String X, String Y) {
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            arrX[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            arrY[Y.charAt(i) - '0']++;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (int d = 9; d >= 0; d--) {
            int common = Math.min(arrX[d], arrY[d]);
            for (int i = 0; i < common; i++) {
                sb.append((char) ('0' + d));
            }
        }
        
        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}