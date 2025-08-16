import java.io.*;
import java.util.*;

public class Main {
  static int idx(char c) {
    if (c == 'A') return 0;
    if (c == 'C') return 1;
    if (c == 'G') return 2;
    return 3; // 'T'
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    String s = br.readLine().trim();

    st = new StringTokenizer(br.readLine());
    int[] need = new int[4];
    for (int i = 0; i < 4; i++) need[i] = Integer.parseInt(st.nextToken());

    int[] cnt = new int[4];
    for (int i = 0; i < P; i++) cnt[idx(s.charAt(i))]++;

    int ans = 0;
    if (cnt[0] >= need[0] && cnt[1] >= need[1] && cnt[2] >= need[2] && cnt[3] >= need[3]) ans++;

    for (int i = P; i < S; i++) {
      cnt[idx(s.charAt(i - P))]--;
      cnt[idx(s.charAt(i))]++;
      if (cnt[0] >= need[0] && cnt[1] >= need[1] && cnt[2] >= need[2] && cnt[3] >= need[3]) ans++;
    }

    bw.write(Integer.toString(ans));
    bw.newLine();
    bw.flush();
  }
}
