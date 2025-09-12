import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
    static class Node implements Comparable<Node> {
        int v, d;
        Node(int v, int d) { this.v = v; this.d = d; }
        public int compareTo(Node o) { return Integer.compare(this.d, o.d); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<Edge>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            if (visited[v]) continue;
            visited[v] = true;
            if (v == end) break;

            for (Edge e : g[v]) {
                if (dist[e.to] > dist[v] + e.w) {
                    dist[e.to] = dist[v] + e.w;
                    pq.offer(new Node(e.to, dist[e.to]));
                }
            }
        }

        bw.write(Integer.toString(dist[end]));
        bw.flush();
    }
}