import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int V;
    static ArrayList<Node>[] g;
    static boolean[] vis;
    static int maxDist = 0;
    static int farNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        g = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                g[from].add(new Node(to, w));
            }
        }

        // 1차 DFS: 임의의 점(1)에서 가장 먼 노드 찾기
        vis = new boolean[V + 1];
        dfs(1, 0);

        // 2차 DFS: farNode에서 가장 먼 거리 찾기 (트리 지름)
        vis = new boolean[V + 1];
        maxDist = 0;
        dfs(farNode, 0);

        bw.write(String.valueOf(maxDist));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int v, int sum) {
        vis[v] = true;
        if (sum > maxDist) {
            maxDist = sum;
            farNode = v;
        }
        for (Node nxt : g[v]) {
            if (!vis[nxt.to]) {
                dfs(nxt.to, sum + nxt.w);
            }
        }
    }
}
