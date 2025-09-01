import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int len = (int)(max - min + 1);

        boolean[] marked = new boolean[len];

        
        long limit = (long)Math.sqrt(max);
        for (long i = 2; i <= limit; i++) {
            long sq = i * i;
            long start = ((min + sq - 1) / sq) * sq;
            for (long v = start; v <= max; v += sq) {
                marked[(int)(v - min)] = true;
            }
        }

        
        int count = 0;
        for (int i = 0; i < len; i++) if (!marked[i]) count++;
        
        bw.write(Integer.toString(count));
        
        
        bw.flush();
    }
}