import java.util.*;

class Solution {
    public int solution(int[][] jobs) {      
        int n = jobs.length;
        int idx = 0;
        int done = 0;
        int time = 0;
        long total = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        
        while (done < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
            
            done++;
        }

        return (int)(total / n);
    }
}