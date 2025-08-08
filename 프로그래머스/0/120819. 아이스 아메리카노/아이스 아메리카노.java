class Solution {
    public int[] solution(int money) {
        int price = 5500;
        int count = money / price;
        int change = money % price;
        int[] answer = {count, change};
        return answer;
    }
}