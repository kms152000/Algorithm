import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int s : scoville) pq.offer((long) s);

        int mix = 0;
        
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) return -1;
            long a = pq.poll();          // 가장 맵지 않은 음식
            long b = pq.poll();          // 두 번째로 맵지 않은 음식
            long c = a + (b * 2);        // 섞은 결과
            pq.offer(c);
            mix++;
        }
        return mix;
    }
}