import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;

  static int nextInt() throws IOException {
    while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  static class Node {
    int val, idx;
    Node(int v, int i) { val = v; idx = i; }
  }

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Deque<Node> dq = new ArrayDeque<>();

    st = null; // 숫자들은 여러 줄에 걸쳐 들어올 수 있으니 토큰 스트리밍
    for (int i = 0; i < N; i++) {
      int x = nextInt();

      while (!dq.isEmpty() && dq.peekLast().val > x) dq.pollLast();
      dq.offerLast(new Node(x, i));
      if (dq.peekFirst().idx <= i - L) dq.pollFirst();

      bw.write(Integer.toString(dq.peekFirst().val));
      if (i + 1 < N) bw.write(' ');
    }
    bw.newLine();
    bw.flush();
  }
}
