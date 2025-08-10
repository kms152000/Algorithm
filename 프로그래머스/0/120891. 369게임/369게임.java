class Solution {
    public int solution(int order) {
        int count = 0;
        
        for (char ch : String.valueOf(order).toCharArray()) {
            if (ch == '3' || ch == '6' || ch == '9') count++;
        }
        
        return count;
    }
}