import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
     Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int last = Integer.MIN_VALUE;

        for (int[] target : targets) {
            if (last <= target[0]) {
                count++;
                last = target[1];
            }
        }

        
        return count;
    }
}