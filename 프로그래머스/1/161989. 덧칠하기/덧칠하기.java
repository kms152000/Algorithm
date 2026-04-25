class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedEnd = 0;

        for (int s : section) {
            if (s > paintedEnd) {
                answer++;
                paintedEnd = s + m - 1;
            }
        }

        return answer;
    }
}