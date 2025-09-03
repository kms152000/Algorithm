import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        
        return a;
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long g = gcd(a, b);

        
        final int CHUNK = 10000;
        char[] ones = new char[CHUNK];
        Arrays.fill(ones, '1');

        while (g >= CHUNK) {
            bw.write(ones);
            g -= CHUNK;
        }
        
        if (g > 0) {
            bw.write(new String(ones, 0, (int) g));
        }
        
        
        bw.flush();
    }
}
