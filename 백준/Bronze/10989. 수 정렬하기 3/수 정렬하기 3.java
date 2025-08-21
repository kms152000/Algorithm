import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(arr);

        for (int n : arr) {
            bw.write(n + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void radixSort(int[] arr) {
        int max = getMax(arr);

        // 자릿수별로 Counting Sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // 현재 자릿수 기준으로 빈도 카운트
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 누적합
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 뒤에서부터 안정 정렬
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // 결과 복사
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
