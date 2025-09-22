import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        
        int[] parent = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    parent[nxt] = cur;
                    q.add(nxt);
                }
            }
        }

        
        for (int i = 2; i <= N; i++){
            sb.append(parent[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
