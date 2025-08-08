import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] strlist) {
        List<Integer> answer = new ArrayList<>();
        for (String str : strlist) {
            answer.add(str.length());
        }
        return answer;
    }
}