import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int maxP = (int)Math.sqrt(B);
        boolean[] isComp = new boolean[maxP + 1];
        isComp[0] = true; if (maxP >= 1) isComp[1] = true;

        
        for (int i = 2; i * i <= maxP; i++) {
            if (!isComp[i]) {
                for (int j = i * i; j <= maxP; j += i) isComp[j] = true;
            }
        }

        
        long count = 0;
        for (int p = 2; p <= maxP; p++) {
            if (isComp[p]) continue;
            long val = (long)p * p;
            while (val <= B) {
                if (val >= A) count++;
                if (val > B / p) break;
                val *= p;
            }
        }

        
        bw.write(Long.toString(count));
        bw.flush();
    }
}