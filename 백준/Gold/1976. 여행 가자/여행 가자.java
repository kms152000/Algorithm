import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    
    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) parent[rb] = ra;
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        boolean ok = true;
        for (int i = 1; i < m; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) != root) {
                ok = false;
                break;
            }
        }

        
        bw.write(ok ? "YES\n" : "NO\n");
        bw.flush();
    }
}