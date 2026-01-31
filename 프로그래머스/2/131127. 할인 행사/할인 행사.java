import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }
        
        Map<String, Integer> days = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            days.put(discount[i], days.getOrDefault(discount[i], 0) + 1);
        }
        
        
        int answer = 0;
        
        for (int first = 0; first <= discount.length - 10; first++) {
            boolean ok = true;
            for (int i = 0; i < want.length; i++) {
                if (days.getOrDefault(want[i], 0) != number[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
            
            if (first == discount.length - 10) break;
            
            String out = discount[first];
            int outCnt = days.get(out) - 1;
            if (outCnt == 0) days.remove(out);
            else days.put(out, outCnt);

            String in = discount[first + 10];
            days.put(in, days.getOrDefault(in, 0) + 1);
        }
        
        return answer;
    }
}