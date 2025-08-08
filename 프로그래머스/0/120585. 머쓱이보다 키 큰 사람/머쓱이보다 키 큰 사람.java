class Solution {
    public int solution(int[] array, int height) {
        int count = 0;
        for (int index : array) {
            if (index > height) count++;
        }
        return count;
    }
}