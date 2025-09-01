import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int r = (int)Math.sqrt(n);
        for (int i = 3; i <= r; i += 2) if (n % i == 0) return false;
        return true;
    }
    
    
    static boolean isPal(int n) {
        String s = Integer.toString(n);
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        if (N <= 2) {
            bw.write("2");
            bw.flush();
            return;
        }
        
        int i = N;
        if (i % 2 == 0) i++;
        while (true) {
            if (isPal(i) && isPrime(i)) {
                bw.write(Integer.toString(i));
                break;
            }
            i += 2;
            if (i > 1003001) {
                bw.write("1003001");
                break;
            }
        }
        
        
        bw.flush();
    }
}