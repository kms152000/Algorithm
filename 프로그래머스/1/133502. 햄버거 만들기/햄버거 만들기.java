class Solution {
    public int solution(int[] ingredient) {
        int n = ingredient.length;
        int[] stack = new int[n];
        int top = 0;
        int count = 0;
        
        for (int x : ingredient) {
            stack[top++] = x;
            
            if (top >= 4 && stack[top - 4] == 1 && stack[top - 3] == 2 && stack[top - 2] == 3 && stack[top - 1] == 1) {
                top -= 4;
                count++;
            }
        }
        
        return count;
    }
}