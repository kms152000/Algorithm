class Solution {
    public int solution(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        } else {
            return num1 % num2;
        }
    }
}