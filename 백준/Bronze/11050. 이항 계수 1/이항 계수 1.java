import java.io.*;
import java.util.*;

public class Main {
    static int comb(int n, int k) {
        if (k == 0 || k == n) return 1;
        return comb(n - 1, k - 1) + comb(n - 1, k);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(comb(n, k));
    }
}