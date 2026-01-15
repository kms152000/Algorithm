class Solution {
    public int solution(int n) {
        int target = Integer.bitCount(n);
        int answer = n + 1;
        
        while (Integer.bitCount(answer) != target) {
            answer++;   
        }
        
        return answer;
    }
}