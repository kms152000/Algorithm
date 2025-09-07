import java.io.*;
import java.util.*;

public class Main {
    static int[] cap = new int[3];
    static boolean[][] visited = new boolean[201][201]; // a,b만 방문 체크
    static boolean[] possible = new boolean[201];       // a==0일 때의 c 기록

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cap[0] = Integer.parseInt(st.nextToken());
        cap[1] = Integer.parseInt(st.nextToken());
        cap[2] = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] start = {0, 0, cap[2]};
        q.add(start);
        visited[0][0] = true;

        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if (a == 0) possible[c] = true;

            for (int i = 0; i < 3; i++) {
                if (cur[i] == 0) continue; // 비어있으면 못 붓는다
                for (int j = 0; j < 3; j++) {
                    if (i == j || cur[j] == cap[j]) continue; // 같은 통, 가득 찬 통으로는 불가
                    int[] nx = Arrays.copyOf(cur, 3);
                    int move = Math.min(nx[i], cap[j] - nx[j]);
                    nx[i] -= move;
                    nx[j] += move;

                    if (!visited[nx[0]][nx[1]]) {
                        visited[nx[0]][nx[1]] = true;
                        q.add(nx);
                    }
                }
            }
        }

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= cap[2]; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }

        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
