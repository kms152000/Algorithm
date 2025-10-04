import java.io.*;
import java.util.*;

public class Main {
    static int N, M, LOG = 17;
    static ArrayList<Integer>[] g;
    static int[][] up;
    static int[] depth;

    
    static void bfs(int root) {
        Arrays.fill(depth, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        depth[root] = 0;
        up[0][root] = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (depth[nxt] == -1) {
                    depth[nxt] = depth[cur] + 1;
                    up[0][nxt] = cur;
                    q.add(nxt);
                }
            }
        }
    }

    
    static void build() {
        for (int k = 1; k <= LOG; k++) {
            for (int v = 1; v <= N; v++) {
                up[k][v] = up[k - 1][ up[k - 1][v] ];
            }
        }
    }

    
    static int lift(int v, int dist) {
        for (int k = 0; dist > 0; k++, dist >>= 1) {
            if ((dist & 1) == 1) v = up[k][v];
        }
        return v;
    }

    
    static int lca(int a, int b) {
        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
        a = lift(a, depth[a] - depth[b]);
        if (a == b) return a;

        for (int k = LOG; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        
        while ((1 << LOG) <= N) LOG++;
        up = new int[LOG + 1][N + 1];
        depth = new int[N + 1];

        bfs(1);
        build();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        
        bw.write(sb.toString());
        bw.flush();
    }
}