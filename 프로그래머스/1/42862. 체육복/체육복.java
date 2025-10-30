import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] state = new int[n + 2];
        Arrays.fill(state, 1);
        
        for (int l : lost) {
            state[l]--;
        }
        for (int r : reserve) {
            state[r]++;
        }

        for (int i = 1; i <= n; i++) {
            if (state[i] == 0) {
                if (state[i - 1] == 2) {
                    state[i - 1]--;
                    state[i]++;
                } else if (state[i + 1] == 2) {
                    state[i + 1]--;
                    state[i]++;
                }
            }
        }

        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (state[i] >= 1) answer++;
        }
        return answer;
    }
}
