import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine().trim()); // 개수
    int M = Integer.parseInt(bf.readLine().trim()); // 목표합

    int[] A = new int[N];
    StringTokenizer st = null;
    for (int i = 0; i < N; i++) {
      while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A);

    int i = 0, j = N - 1, count = 0;
    while (i < j) {
      int sum = A[i] + A[j];
      if (sum < M) i++;
      else if (sum > M) j--;
      else { count++; i++; j--; }
    }
    System.out.println(count);
  }
}