import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        }
        
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    
    static int[] parent, size;

    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (size[a] < size[b]) { int t = a; a = b; b = t; } // a가 큰 집합
        parent[b] = a;
        size[a] += size[b];
        return true;
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);

        
        parent = new int[V + 1];
        size = new int[V + 1];
        for (int i = 1; i <= V; i++) { parent[i] = i; size[i] = 1; }

        long mst = 0;
        int picked = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                mst += e.w;
                if (++picked == V - 1) break;
            }
        }

        
        bw.write(mst + "\n");
        bw.flush();
    }
}