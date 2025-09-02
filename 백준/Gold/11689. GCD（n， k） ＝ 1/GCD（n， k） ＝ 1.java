import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine().trim());
        long result = n;

        
        long x = n;
        for (long p = 2; p * p <= x; p++) {
            if (x % p == 0) {
                result = result / p * (p - 1);
                while (x % p == 0) x /= p;
            }
        }
        
        if (x > 1) result = result / x * (x - 1);

        
        bw.write(Long.toString(result));
        bw.flush();
    }
}
