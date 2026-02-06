import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[n - 1 - i];
        }
        return sum;
    }
}