class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int time = 0;
            for (int j = i + 1; j < n; j++) {
                time++;
                if (prices[j] < prices[i]) break;
            }
            answer[i] = time;
        }

        return answer;
    }
}