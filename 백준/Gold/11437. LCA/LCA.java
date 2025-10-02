import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] depth;
    static int[] parent;

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        
        parent = new int[N + 1];
        depth = new int[N + 1];

        bfs(1);

        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    
    static void bfs(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        depth[root] = 1;
        parent[root] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (depth[nxt] == 0) {
                    parent[nxt] = cur;
                    depth[nxt] = depth[cur] + 1;
                    q.add(nxt);
                }
            }
        }
    }

    
    static int lca(int a, int b) {
        // 깊이가 더 큰 쪽을 위로 끌어올림
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];
        // 같은 높이에서 만날 때까지 올림
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}