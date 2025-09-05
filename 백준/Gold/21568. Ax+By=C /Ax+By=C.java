import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long extGcd(long a, long b, long[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long g = extGcd(b, a % b, xy);
        long x = xy[0], y = xy[1];
        xy[0] = y;
        xy[1] = x - (a / b) * y;
        return g;
    }

  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

      
        if (A == 0 && B == 0) {
            if (C == 0) {
                bw.write("0 0\n");
            } else {
                bw.write("-1\n");
            }
            bw.flush();
            return;
        }

      
        long a = Math.abs(A), b = Math.abs(B);
        long[] xy = new long[2];
        long g = extGcd(a, b, xy); // xy[0]*a + xy[1]*b = g

        if (C % g != 0) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

      
        long k = C / g;
        long x = xy[0] * k;
        long y = xy[1] * k;

        if (A < 0) x = -x;
        if (B < 0) y = -y;

      
        bw.write(x + " " + y + "\n");
        bw.flush();
    }
}
