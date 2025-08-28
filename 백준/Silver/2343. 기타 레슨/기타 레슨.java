import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] lessons;

    static boolean canDivide(int size) {
        int count = 1; // 블루레이 개수
        int sum = 0;
        for (int len : lessons) {
            if (sum + len > size) { 
                count++; 
                sum = 0;
            }
            sum += len;
        }
        return count <= M; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lessons = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lessons[i]); // 최소 크기 (가장 긴 강의)
            right += lessons[i];               // 최대 크기 (전체 합)
        }

        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDivide(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
