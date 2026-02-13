import java.util.*;

class Solution {
    public int[] solution(String s) {
        String inner = s.substring(2, s.length() - 2);
        String[] sets = inner.split("\\},\\{");
        
        Arrays.sort(sets, Comparator.comparingInt(String::length));
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        for (String set : sets) {
            String[] numbers = set.split(",");
            for (String numStr : numbers) {
                int num = Integer.parseInt(numStr);
                if (!visited.contains(num)) {
                    visited.add(num);
                    result.add(num);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}