import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minCount = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int count = i + 1;
                int cur = minCount.getOrDefault(c, Integer.MAX_VALUE);
                if (count < cur) minCount.put(c, count);
            }
        }
        
        int[] answer = new int[targets.length];

        for (int t = 0; t < targets.length; t++) {
            String target = targets[t];
            int sum = 0;

            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                // null 값 처리를 위해 Integer 사용
                Integer count = minCount.get(c);
                if (count == null) {
                    sum = -1;
                    break;
                }
                sum += count;
            }

            answer[t] = sum;
        }

        return answer;
    }
}