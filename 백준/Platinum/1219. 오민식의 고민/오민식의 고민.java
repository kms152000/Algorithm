import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from, to;
        int cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    
    static final long NEG_INF = Long.MIN_VALUE / 4; // 안전한 -INF
    static final long POS_INF = Long.MAX_VALUE / 4; // 사이클 전파 표식
    static int N, M, S, E;
    static Edge[] edges;
    static long[] earn, dist;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            edges[i] = new Edge(a, b, c);
        }

        
        earn = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) earn[i] = Long.parseLong(st.nextToken());

        dist = new long[N];
        for (int i = 0; i < N; i++) dist[i] = NEG_INF;
        dist[S] = earn[S];

        
        // 1) N-1번 이득 최대화(Bellman-Ford 변형: 최대 합)
        for (int i = 0; i < N - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                
                if (dist[e.from] == NEG_INF) continue; // 아직 도달 불가
                if (dist[e.to] < dist[e.from] - e.cost + earn[e.to]) {
                    dist[e.to] = dist[e.from] - e.cost + earn[e.to];
                    updated = true;
                }
            }
            
            if (!updated) break;
        }

        
        // 2) 양의 사이클(돈 무한)을 도달/전파 표시
        for (int i = 0; i < N; i++) { // 여유 있게 N번 전파
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                
                if (dist[e.from] == NEG_INF) continue;

                if (dist[e.from] == POS_INF) {
                    dist[e.to] = POS_INF; // 사이클로부터 전파
                }
                else if (dist[e.to] < dist[e.from] - e.cost + earn[e.to]) {
                    dist[e.to] = POS_INF; // 더 좋아진다면 양의 사이클 영향
                }
            }
        }

        
        if (dist[E] == NEG_INF) {
            bw.write("gg\n"); // 도달 불가
        }
        else if (dist[E] == POS_INF) {
            bw.write("Gee\n"); // 무한히 벌 수 있음
        }
        else {
            bw.write(dist[E] + "\n"); // 최대 수익
        }

        
        bw.flush();
        bw.close();
        br.close();
    }
}