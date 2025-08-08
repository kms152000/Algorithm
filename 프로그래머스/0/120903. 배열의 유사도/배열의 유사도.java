import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        for (String str : s1) {
            set1.add(str);
        }

        int count = 0;
        for (String str : s2) {
            if (set1.contains(str)) {
                count++;
            }
        }
        return count;
    }
}