import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] paper = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }


        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }


        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int idx = queue.removeFirst();
            sb.append(idx).append(' ');

            if (queue.isEmpty()) break;

            int move = paper[idx];
            if (move > 0) {
                int k = (move - 1) % queue.size();

                for (int i = 0; i < k; i++) {
                    queue.addLast(queue.removeFirst());
                }
            }
            else {
                int k = (-move) % queue.size();

                for (int i = 0; i < k; i++) {
                    queue.addFirst(queue.removeLast());
                }
            }
        }

        bw.write(sb.toString());


        bw.flush();
        bw.close();
        br.close();
    }
}