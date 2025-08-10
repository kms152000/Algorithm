class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] result = new int[len];
        
        if (direction.equals("right")) {
            result[0] = numbers[len - 1];
            for (int i = 1; i < len; i++) {
                result[i] = numbers[i - 1];
            }
        } else {
            result[len - 1] = numbers[0];
            for (int i = 0; i < len - 1; i++) {
                result[i] = numbers[i + 1];
            }
        }
        
        return result;
    }
}
