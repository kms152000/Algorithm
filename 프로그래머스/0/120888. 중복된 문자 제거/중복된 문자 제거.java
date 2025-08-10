import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        
        for (char ch : my_string.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}