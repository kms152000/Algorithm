import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<Integer> empties = new ArrayList<>();
        List<Integer> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empties.add(i * M + j);
                else if (map[i][j] == 2) viruses.add(i * M + j);
            }
        }

        int emptyCnt = empties.size();
        int maxSafe = 0;

        int[][] board = new int[N][M];           // 재사용용 보드
        ArrayDeque<int[]> q = new ArrayDeque<>(); // 재사용용 큐

        for (int a = 0; a < emptyCnt; a++) {
            for (int b = a + 1; b < emptyCnt; b++) {
                for (int c = b + 1; c < emptyCnt; c++) {
                    // 보드 복사
                    for (int i = 0; i < N; i++) {
                        System.arraycopy(map[i], 0, board[i], 0, M);
                    }

                    // 벽 3개 세우기
                    int pa = empties.get(a); board[pa / M][pa % M] = 1;
                    int pb = empties.get(b); board[pb / M][pb % M] = 1;
                    int pc = empties.get(c); board[pc / M][pc % M] = 1;

                    // 바이러스 확산
                    q.clear();
                    for (int pos : viruses) q.offer(new int[]{pos / M, pos % M});

                    int infected = 0;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (board[nx][ny] != 0) continue;
                            board[nx][ny] = 2;
                            infected++;
                            q.offer(new int[]{nx, ny});
                        }
                    }

                    // 안전 영역 = 전체 빈칸 - 새로 세운 벽 3 - 감염된 칸
                    int safe = emptyCnt - 3 - infected;
                    if (safe > maxSafe) maxSafe = safe;
                }
            }
        }

        bw.write(Integer.toString(maxSafe));
        bw.flush();
    }
}