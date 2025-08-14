import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];
        count[0] = 1; // 누적합이 0인 경우(S0) 미리 카운트

        st = new StringTokenizer(br.readLine());
        long prefix = 0;
        int read = 0;

        while (true) {
            while (st.hasMoreTokens() && read < N) {
                long a = Long.parseLong(st.nextToken());
                prefix = (prefix + a) % M;
                count[(int) prefix]++;
                read++;
            }
            if (read == N) break;
            st = new StringTokenizer(br.readLine());
        }

        long ans = 0;
        for (int r = 0; r < M; r++) {
            long c = count[r];
            if (c >= 2) ans += c * (c - 1) / 2;
        }

        bw.write(Long.toString(ans));
        bw.flush();
    }
}
