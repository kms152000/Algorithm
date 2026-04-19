class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            String prev = "";
            int idx = 0;
            boolean possible = true;

            while (idx < b.length()) {
                boolean matched = false;

                for (String word : words) {
                    if (word.equals(prev)) {
                        continue;
                    }

                    if (idx + word.length() <= b.length() &&
                            b.substring(idx, idx + word.length()).equals(word)) {
                        idx += word.length();
                        prev = word;
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}