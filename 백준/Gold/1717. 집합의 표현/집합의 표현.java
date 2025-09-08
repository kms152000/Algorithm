import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;

    static int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]]; // path compression (halving)
            x = parent[x];
        }
        
        return x;
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb) return;
        
        if (size[ra] < size[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }
        
        parent[rb] = ra;
        size[ra] += size[rb];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } 
            else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
            }
        }

        
        bw.write(sb.toString());
        bw.flush();
    }
}