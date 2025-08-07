class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = new int[2];
        
        for (int num : num_list) {
            if (num % 2 == 0) arr[0]++;
            else arr[1]++;
        }
        
        return arr;
    }
}