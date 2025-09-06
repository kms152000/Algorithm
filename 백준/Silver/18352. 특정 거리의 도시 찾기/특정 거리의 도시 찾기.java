import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        
        // 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[X] = 0;

        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }


        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                bw.write(i + "\n");
                found = true;
            }
        }

        if (!found) bw.write("-1\n");

        
        bw.flush();
        bw.close();
        br.close();
    }
}