import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] vis;
    static final int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static final int[] dy = {0, 1, 0, -1};

    
    static class Edge implements Comparable<Edge> {
        int a, b, w;
        Edge(int a, int b, int w) { this.a = a; this.b = b; this.w = w; }
        public int compareTo(Edge o) { return this.w - o.w; }
    }

    
    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n + 1];
            r = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) { int t = a; a = b; b = t; }
            p[b] = a;
            if (r[a] == r[b]) r[a]++;
            return true;
        }
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1) 섬 라벨링 (1,2,3...)
        int islands = labelIslands();
        if (islands <= 1) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 2) 다리 후보(간선) 만들기: 행/열 스캔으로 가장 단순하게
        List<Edge> edges = buildEdgesByScan(islands);

        // 3) MST (크루스칼)
        int ans = kruskal(islands, edges);

        bw.write(Integer.toString(ans));
        bw.flush();
    }

    
    // BFS로 연결된 땅(원래 1)을 같은 섬 번호로 바꿔치기
    static int labelIslands() {
        vis = new boolean[N][M];
        int id = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 1 && !vis[x][y]) {
                    id++;
                    bfsLabel(x, y, id);
                }
            }
        }
        return id;
    }

    
    static void bfsLabel(int sx, int sy, int id) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        vis[sx][sy] = true;
        map[sx][sy] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!vis[nx][ny] && map[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    map[nx][ny] = id;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    
    // 행/열을 한 줄씩 훑어서 "바다 길이 >= 2"로 만나는 두 섬 사이 최소 다리 길이 수집
    static List<Edge> buildEdgesByScan(int islands) {
        final int INF = 1_000_000_000;
        int[][] best = new int[islands + 1][islands + 1];
        for (int i = 1; i <= islands; i++) Arrays.fill(best[i], INF);

        // 가로 스캔
        for (int i = 0; i < N; i++) {
            int prev = 0; // 직전에 본 섬 번호(바다 전의 섬), 0은 바다 또는 없음
            int len = 0;  // prev 섬 이후 연속 바다 길이
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    if (prev != 0) len++;
                } else { // 땅(섬 번호)
                    int cur = map[i][j];
                    if (prev != 0 && prev != cur && len >= 2) {
                        if (len < best[prev][cur]) {
                            best[prev][cur] = len;
                            best[cur][prev] = len;
                        }
                    }
                    // 같은 섬을 다시 만났거나 다리 조건 불충족이면 초기화만
                    prev = cur;
                    len = 0;
                }
            }
        }

        
        // 세로 스캔
        for (int j = 0; j < M; j++) {
            int prev = 0;
            int len = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 0) {
                    if (prev != 0) len++;
                } else {
                    int cur = map[i][j];
                    if (prev != 0 && prev != cur && len >= 2) {
                        if (len < best[prev][cur]) {
                            best[prev][cur] = len;
                            best[cur][prev] = len;
                        }
                    }
                    prev = cur;
                    len = 0;
                }
            }
        }

        
        // 간선 리스트로 변환
        List<Edge> edges = new ArrayList<>();
        for (int a = 1; a <= islands; a++) {
            for (int b = a + 1; b <= islands; b++) {
                if (best[a][b] != INF) edges.add(new Edge(a, b, best[a][b]));
            }
        }
        return edges;
    }

    
    static int kruskal(int islands, List<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(islands);
        int used = 0, total = 0;
        for (Edge e : edges) {
            if (dsu.union(e.a, e.b)) {
                total += e.w;
                used++;
                if (used == islands - 1) break;
            }
        }
        return (used == islands - 1) ? total : -1;
    }
}