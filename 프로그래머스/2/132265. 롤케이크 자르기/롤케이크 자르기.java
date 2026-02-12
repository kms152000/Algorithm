import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        Set<Integer> leftSet = new HashSet<>();

        for (int i = 0; i < topping.length - 1; i++) {
            int current = topping[i];

            leftSet.add(current);

            rightMap.put(current, rightMap.get(current) - 1);
            if (rightMap.get(current) == 0) {
                rightMap.remove(current);
            }

            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}