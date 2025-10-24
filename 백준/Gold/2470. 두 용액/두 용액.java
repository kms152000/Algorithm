import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        
        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int answerL = 0;
        int answerR = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answerL = arr[left];
                answerR = arr[right];
            }

            if (sum > 0) right--;
            else left++;
        }

        bw.write(answerL + " " + answerR);
        bw.flush();
    }
}