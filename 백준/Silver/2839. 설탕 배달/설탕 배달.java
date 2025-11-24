import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int minCount = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i <= N / 5; i++) {
            for (int j = 0; j <= N / 3; j++) {
                if (5 * i + 3 * j == N) {
                    minCount = Math.min(minCount, i + j);
                    found = true;
                }
            }
        }

        if (found) {
            bw.write(String.valueOf(minCount));
        } else {
            bw.write("-1");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}