import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int[] P = new int[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int key = P[i];
            int j = i - 1;
            while (j >= 0 && P[j] > key) {
                P[j + 1] = P[j];
                j--;
            }
            P[j + 1] = key;
        }

        long sum = 0, total = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i];
            total += sum;
        }

        bw.write(Long.toString(total));
        bw.flush();
    }
}
