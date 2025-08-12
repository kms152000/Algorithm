import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int x : arr) {
            if (stack.isEmpty() || stack.peekLast() != x) {
                stack.addLast(x);
            }
        }
        
        int[] answer = new int[stack.size()];
        int i = 0;
        
        for (int v : stack) answer[i++] = v;
        
        return answer;
    }
}