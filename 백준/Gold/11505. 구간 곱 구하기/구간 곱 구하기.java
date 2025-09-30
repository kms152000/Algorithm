import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr;
    static long[] tree;
    static final long MOD = 1_000_000_007L;

    
    static long init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];
        int m = (s + e) >>> 1;
        return tree[node] = (init(node << 1, s, m) * init(node << 1 | 1, m + 1, e)) % MOD;
    }

    
    static long query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return 1;
        if (l <= s && e <= r) return tree[node];
        int m = (s + e) >>> 1;
        
        return (query(node << 1, s, m, l, r) * query(node << 1 | 1, m + 1, e, l, r)) % MOD;
    }

    
    static void update(int node, int s, int e, int idx, long val) {
        if (idx < s || idx > e) return;  
        if (s == e) {
            tree[node] = val;
            return;
        }
        
        int m = (s + e) >>> 1;
        update(node << 1, s, m, idx, val);
        update(node << 1 | 1, m + 1, e, idx, val);
        
        tree[node] = (tree[node << 1] * tree[node << 1 | 1]) % MOD;
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());

        tree = new long[4 * N];
        init(1, 1, N);

        
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                arr[b] = c;
                update(1, 1, N, b, c);
            } else if (a == 2) {
                sb.append(query(1, 1, N, b, (int)c)).append('\n');
            }
        }
        

        bw.write(sb.toString());
        bw.flush();
    }
}