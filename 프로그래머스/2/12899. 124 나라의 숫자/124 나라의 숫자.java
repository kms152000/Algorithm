class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] nums = {"4", "1", "2"};
        
        while (n > 0) {
            int remainder = n % 3;
            sb.append(nums[remainder]);
            n = (n - 1) / 3;
        }
        
        
        return sb.reverse().toString();
    }
}