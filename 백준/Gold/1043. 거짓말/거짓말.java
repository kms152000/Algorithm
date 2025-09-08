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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] truth = new int[t];
        for (int i = 0; i < t; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(arr);
            // 같은 파티 참석자들 union
            for (int j = 1; j < cnt; j++) {
                union(arr[0], arr[j]);
            }
        }

        // 진실 아는 사람들의 root 표시
        boolean[] know = new boolean[n + 1];
        for (int x : truth) {
            know[find(x)] = true;
        }

        // 진실 아는 root로 연결된 사람들 다시 표시
        for (int i = 1; i <= n; i++) {
            if (know[find(i)]) know[i] = true;
        }

        int ans = 0;
        for (int[] party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (know[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ans++;
        }

        
        bw.write(ans + "\n");
        bw.flush();
    }
}
