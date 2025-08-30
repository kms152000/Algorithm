import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // start
            meetings[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // end asc
            return Integer.compare(a[0], b[0]); // start asc
        });

        int count = 0;
        int lastEnd = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
    }
}
