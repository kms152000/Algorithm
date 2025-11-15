import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] distance = new int[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        distance[0][0] = 1;

        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n - 1 && y == m - 1) {
                return distance[x][y];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (distance[nx][ny] != 0) continue;

                distance[nx][ny] = distance[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        
        return -1;
    }
}