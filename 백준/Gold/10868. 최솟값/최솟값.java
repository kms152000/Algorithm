import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;
    static final int INF = Integer.MAX_VALUE;

    
    static int init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];
        int m = (s + e) >>> 1;
        int left = init(node << 1, s, m);
        int right = init(node << 1 | 1, m + 1, e);
        return tree[node] = Math.min(left, right);
    }

    
    static int query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return INF;
        if (l <= s && e <= r) return tree[node];
        int m = (s + e) >>> 1;
        return Math.min(query(node << 1, s, m, l, r),
                        query(node << 1 | 1, m + 1, e, l, r));
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        tree = new int[4 * N];
        init(1, 1, N);

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) { int t = a; a = b; b = t; }
            sb.append(query(1, 1, N, a, b)).append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}