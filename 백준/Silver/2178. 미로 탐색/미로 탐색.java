import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 = 0,1,2,3
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        vis  = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) map[i][j] = row[j] - '0';
        }

        bfs(0, 0);

        bw.write(String.valueOf(dist[N - 1][M - 1]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[sx][sy] = true;
        dist[sx][sy] = 1;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (vis[nx][ny] || map[nx][ny] == 0) continue;

                vis[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
