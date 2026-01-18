class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String p : parts) {
            int v = Integer.parseInt(p);
            if (v < min) min = v;
            if (v > max) max = v;
        }

        return min + " " + max;
    }
}