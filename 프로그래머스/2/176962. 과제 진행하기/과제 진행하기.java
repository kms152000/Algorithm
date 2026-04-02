import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> toMinute(a[1]) - toMinute(b[1]));
        
        Stack<Task> stack = new Stack<>();
        String[] answer = new String[plans.length];
        int idx = 0;
        
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = toMinute(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            
            if (i < plans.length - 1) {
                int nextStart = toMinute(plans[i + 1][1]);
                int available = nextStart - start;

                if (playtime <= available) {
                    answer[idx++] = name;
                    int remain = available - playtime;

                    while (!stack.isEmpty() && remain > 0) {
                        Task prev = stack.pop();

                        if (prev.remain <= remain) {
                            remain -= prev.remain;
                            answer[idx++] = prev.name;
                        } else {
                            prev.remain -= remain;
                            stack.push(prev);
                            remain = 0;
                        }
                    }
                } else {
                    stack.push(new Task(name, playtime - available));
                }
            } else {
                answer[idx++] = name;
            }
        }
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }
    
    
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt((t[1]));
    }
    
    
    static class Task {
        String name;
        int remain;
        
        Task(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }
}