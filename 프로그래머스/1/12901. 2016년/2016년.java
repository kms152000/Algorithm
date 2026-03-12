class Solution {
    public String solution(int a, int b) {

        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

        int total = b;

        for (int i = 0; i < a - 1; i++) {
            total += month[i];
        }

        return day[(total + 4) % 7];
    }
}