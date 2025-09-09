import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        int[] indeg = new int[N + 1];
        int[] time = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = time[i]; // 최소 자기 건설 시간으로 초기화

            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                graph[pre].add(i);  // pre → i
                indeg[i]++;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                dp[nxt] = Math.max(dp[nxt], dp[cur] + time[nxt]);
                if (--indeg[nxt] == 0) q.add(nxt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append("\n");
        }

        
        bw.write(sb.toString());
        bw.flush();
    }
}