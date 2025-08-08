import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int middleIndex = array.length / 2;
        return array[middleIndex];
    }
}