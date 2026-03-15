class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] blocked = new boolean[26];

        for (int i = 0; i < skip.length(); i++) {
            blocked[skip.charAt(i) - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;

            while (count < index) {
                c++;
                if (c > 'z') {
                    c = 'a';
                }

                if (!blocked[c - 'a']) {
                    count++;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}