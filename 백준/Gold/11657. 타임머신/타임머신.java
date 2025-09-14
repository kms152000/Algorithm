import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from, to, cost;
        
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static Edge[] edges;
    static long[] dist;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        dist = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            edges[i] = new Edge(a, b, c);
        }


        if (bellmanFord(1)) {
            bw.write("-1\n"); // 음수 사이클 존재
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(dist[i] + "\n");
                }
            }
        }

        
        bw.flush();
        bw.close();
        br.close();
    }

    
    static boolean bellmanFord(int start) {
        dist[start] = 0;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        // 음수 사이클 체크
        for (int j = 0; j < M; j++) {
            Edge e = edges[j];
            
            if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                return true; // 음수 사이클 존재
            }
        }
        
        return false;
    }
}