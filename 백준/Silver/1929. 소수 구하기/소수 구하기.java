import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isComp = new boolean[N + 1];
        if (N >= 0) isComp[0] = true;
        if (N >= 1) isComp[1] = true;

        int limit = (int)Math.sqrt(N);
        for (int i = 2; i <= limit; i++) {
            if (!isComp[i]) {
                for (long j = (long)i * i; j <= N; j += i) isComp[(int)j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = Math.max(2, M); i <= N; i++) {
            if (!isComp[i]) sb.append(i).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}