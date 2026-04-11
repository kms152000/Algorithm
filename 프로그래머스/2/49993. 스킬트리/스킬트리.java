class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            int idx = 0;
            boolean possible = true;

            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                int pos = skill.indexOf(c);

                if (pos == -1) {
                    continue;
                }

                if (pos == idx) {
                    idx++;
                } else {
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