class Solution {
    public String solution(int age) {
        String digits = String.valueOf(age);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < digits.length(); i++) {
            int d = digits.charAt(i) - '0';
            sb.append((char) ('a' + d));
        }
        
        return sb.toString();
    }
}
