import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] left = {0, 5, 5, 5, 5, 5}; // 크기 1~5 색종이 각 5장
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int used) {
        if (used >= ans) return; // 가지치기

        int pos = nextOnePos();
        if (pos == -1) { // 모두 덮음
            ans = Math.min(ans, used);
            return;
        }

        int r = pos / 10, c = pos % 10;

        for (int size = 5; size >= 1; size--) {
            if (left[size] == 0) continue;
            if (canPlace(r, c, size)) {
                place(r, c, size, 0);
                left[size]--;
                dfs(used + 1);
                left[size]++;
                place(r, c, size, 1);
            }
        }
    }

    static int nextOnePos() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) return i * 10 + j;
            }
        }
        return -1;
    }

    static boolean canPlace(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void place(int r, int c, int size, int val) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = val;
            }
        }
    }
}