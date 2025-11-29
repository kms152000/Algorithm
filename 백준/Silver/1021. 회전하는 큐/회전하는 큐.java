import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int moveCount = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int x : queue) {
                if (x == target) break;
                idx++;
            }

            int size = queue.size();

            if (idx <= size / 2) {
                for (int k = 0; k < idx; k++) {
                    queue.addLast(queue.removeFirst());
                    moveCount++;
                }
            } else {
                int move = size - idx;
                for (int k = 0; k < move; k++) {
                    queue.addFirst(queue.removeLast());
                    moveCount++;
                }
            }

            queue.removeFirst();
        }

        bw.write(Integer.toString(moveCount));
        bw.flush();
        bw.close();
        br.close();
    }
}