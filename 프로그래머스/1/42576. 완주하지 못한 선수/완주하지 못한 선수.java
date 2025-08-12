import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return ""; // 모든 사람이 완주한 경우 (문제상 그런 경우는 없지만 문법적으로 필요)
    }
}
