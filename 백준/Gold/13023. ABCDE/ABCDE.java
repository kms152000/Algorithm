import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found = false;

    static boolean dfs(int u, int depth) {
        if (depth == 5) return true; // 5명 연속 관계(길이 4) 완성
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                if (dfs(v, depth + 1)) return true;
            }
        }
        visited[u] = false; // 백트래킹
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (dfs(i, 1)) {
                bw.write("1\n");
                bw.flush();
                return;
            }
        }
        bw.write("0\n");
        bw.flush();
    }
}
