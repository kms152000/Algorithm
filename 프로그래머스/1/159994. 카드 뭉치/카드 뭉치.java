class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int i = 0;
        int j = 0;

        for (String w : goal) {
            if (i < cards1.length && cards1[i].equals(w)) {
                i++;
            } else if (j < cards2.length && cards2[j].equals(w)) {
                j++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}