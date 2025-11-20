import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        
        
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > maxH) maxH = a[i];
        }

        int lo = 0;
        int hi = maxH;
        int ans = 0;

        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            long sum = 0L;
            for (int h : a) {
                if (h > mid) sum += (h - mid);
                if (sum >= M) break;
            }

            if (sum >= M) {
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        
        bw.write(ans + "\n");
        bw.flush();
    }
}