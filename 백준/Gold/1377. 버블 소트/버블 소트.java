import java.io.*;
import java.util.*;

public class Main {
    static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int maxMove = 0;
        for (int i = 0; i < N; i++) {
            int move = A[i].index - i;
            if (move > maxMove) maxMove = move;
        }

        bw.write(String.valueOf(maxMove + 1));
        bw.flush();
        br.close();
        bw.close();
    }
}
