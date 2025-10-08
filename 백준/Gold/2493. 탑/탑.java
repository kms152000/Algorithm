import java.io.*;
import java.util.*;

public class Main {
    static class Tower {
        int idx, height;
        
        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < h) stack.pop();

            if (stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek().idx;

            stack.push(new Tower(i + 1, h));
        }

        for (int i = 0; i < N; i++) sb.append(result[i]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}