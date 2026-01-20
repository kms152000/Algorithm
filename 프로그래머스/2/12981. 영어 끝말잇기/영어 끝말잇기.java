import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            
            boolean end = false;
            
            
            if ( (prev.charAt(prev.length() - 1) != cur.charAt(0)) ) {
                end = true;
            }
            if (used.contains(cur)) {
                end = true;
            }
            if (end) {
                int person = (i % n) + 1;   // i번째 단어를 말한 사람 번호
                int turn = (i / n) + 1;     // 그 사람의 몇 번째 차례인지
                return new int[]{person, turn};
            }
            
            
            used.add(cur);
        }
        
        return new int[]{0, 0};
    }
}