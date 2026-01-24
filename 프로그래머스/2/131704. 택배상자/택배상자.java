class Solution {
    public int solution(int[] order) {
        int[] stack = new int[order.length];
        int count = 0;
        
        int top = -1;
        int cur = 1;
        
        
        for (int i : order) {
            while (cur <= order.length && cur < i) {
                stack[++top] = cur++;
            }
            
            if (top >= 0 && stack[top] == i) {
                top--;
                count++;
                continue;
            }
            
            if (cur == i) {
                cur++;
                count++;
            } else {
                break;
            }
            
        }
        return count;
    }
}