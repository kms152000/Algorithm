import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return st.nextToken();
  }

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(next());
    long[] a = new long[N];
    for (int i = 0; i < N; i++) a[i] = Long.parseLong(next());

    Arrays.sort(a);

    int good = 0;
    for (int k = 0; k < N; k++) {
      int i = 0, j = N - 1;
      long target = a[k];
      while (i < j) {
        if (i == k) { i++; continue; }
        if (j == k) { j--; continue; }
        long sum = a[i] + a[j];
        if (sum == target) { good++; break; }
        if (sum < target) i++;
        else j--;
      }
    }

    bw.write(Integer.toString(good));
    bw.newLine();
    bw.flush();
  }
}
