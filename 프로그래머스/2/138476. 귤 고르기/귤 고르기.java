import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int pick = 0;
        int type = 0;
        
        for (int c : counts) {
            pick += c;
            type++;
            if (pick >= k) break;
        }
        
        return type;
    }
}