import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0];
            int pri = cur[1];

            if (pri == pq.peek()) {
                pq.poll();
                order++;

                if (idx == location) {
                    return order;
                }
            } 
            else {
                queue.offer(cur);
            }
        }

        return -1;
    }
}