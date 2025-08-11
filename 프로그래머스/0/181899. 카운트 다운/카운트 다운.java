import java.util.*;

class Solution {
    public List<Integer> solution(int start_num, int end_num) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = start_num; i >= end_num; i--) {
            result.add(i);
        }
        
        return result;
    }
}
