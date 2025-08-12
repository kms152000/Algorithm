import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0] - 1;
            int j = commands[idx][1];
            int k = commands[idx][2] - 1;

            int[] slice = Arrays.copyOfRange(array, i, j);
            Arrays.sort(slice);
            answer[idx] = slice[k];
        }
        
        return answer;
    }
}