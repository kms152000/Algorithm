// BOJ 7576 - 토마토 (Java, BFS로 익는 날짜 계산)
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        
        box = new int[N][M];
        dist = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) { // 익은 토마토
                    q.add(new int[]{i, j});
                }
                if (box[i][j] == 0) dist[i][j] = -1; // 아직 안 익은 토마토만 거리 계산 대상
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] != -1) continue; // 이미 익었거나 방문한 곳
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1) { // 안 익은 토마토 남음
                    bw.write("-1\n");
                    bw.flush();
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}