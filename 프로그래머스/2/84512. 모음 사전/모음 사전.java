class Solution {
    public int solution(String word) {
        int[] cases = {781, 156, 31, 6, 1};
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int index = 0;
            
            for (int j = 0; j < 5; j++) {
                if (word.charAt(i) == vowels[j]) {
                    index = j;
                    break;
                }
            }
            answer += index * cases[i] + 1;
        }
        
        return answer;
    }
}