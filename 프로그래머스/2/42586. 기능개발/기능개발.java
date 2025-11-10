import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        
        for (int i = 0; i < n; i++) {
            int left = 100 - progresses[i];
            days[i] = (left + speeds[i] - 1) / speeds[i];
        }

        List<Integer> list = new ArrayList<>();
        int cur = days[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= cur) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                cur = days[i];
            }
        }
        list.add(cnt);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}