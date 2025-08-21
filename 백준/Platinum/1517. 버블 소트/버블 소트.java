import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, tmp;
    static long swaps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        arr = new int[N];
        tmp = new int[N];

        int idx = 0;
        while (idx < N) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && idx < N) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        mergeSort(0, N - 1);

        bw.write(Long.toString(swaps));
        bw.flush();
        bw.close();
        br.close();
    }

    static void mergeSort(int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >>> 1;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                swaps += (mid - i + 1);
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        for (int t = left; t <= right; t++) arr[t] = tmp[t];
    }
}
