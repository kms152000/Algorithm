import java.io.*;

public class Main {
    static int N;
    static int[] col;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        col = new int[N];

        dfs(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int row) {
        if (row == N) { // N개의 퀸을 다 놓았다면
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i; // row행, i열에 퀸을 놓음
            if (isSafe(row)) { 
                dfs(row + 1);
            }
        }
    }

    static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열인지 확인
            if (col[i] == col[row]) return false;
            // 대각선에 있는지 확인 (행 차이 == 열 차이)
            if (Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}