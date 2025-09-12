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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Edge>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
        }

        // 각 정점까지의 경로들을 저장하는 max-heap (k개까지만 유지)
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) dist[i] = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1].add(0);
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int d = cur.d;

            for (Edge e : g[v]) {
                int nd = d + e.w;

                if (dist[e.to].size() < k) {
                    dist[e.to].add(nd);
                    pq.add(new Node(e.to, nd));
                } else if (dist[e.to].peek() > nd) {
                    dist[e.to].poll();
                    dist[e.to].add(nd);
                    pq.add(new Node(e.to, nd));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) sb.append(-1).append("\n");
            else sb.append(dist[i].peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}