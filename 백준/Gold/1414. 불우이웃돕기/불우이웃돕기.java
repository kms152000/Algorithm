import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    
    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n]; r = new int[n];
            
            for (int i = 0; i < n; i++) {
                p[i] = i;   
            }
        }
        
        
        int find(int x) {
            return p[x] == x ? x : (p[x] = find(p[x]));
        }
        
        
        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) {
                int t = a;
                a = b;
                b = t;
            }
            p[b] = a;
            if (r[a] == r[b]) r[a]++;
            
            return true;
        }
    }

    
    static int toLen(char c) {
        if (c == '0') return 0;
        if ('a' <= c && c <= 'z') return c - 'a' + 1;
        return c - 'A' + 27;
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        List<Edge> edges = new ArrayList<>();
        int total = 0;

        char[][] ch = new char[N][];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            ch[i] = s.toCharArray();
            
            for (int j = 0; j < N; j++) {
                int len = toLen(ch[i][j]);
                total += len;
                if (i != j && len > 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }

        
        Collections.sort(edges);
        DSU dsu = new DSU(N);
        int used = 0, keep = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                keep += e.w;
                used++;
                if (used == N - 1) break;
            }
        }

        if (N == 1) {
            bw.write(Integer.toString(total)); // 혼자면 전부 기부 가능
        } 
        else if (used != N - 1) {
            bw.write("-1"); // 모두 연결 불가
        } 
        else {
            bw.write(Integer.toString(total - keep)); // 기부
        }
        bw.flush();
    }
}