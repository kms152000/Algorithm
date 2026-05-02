class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int win : win_nums) {
                if (lotto == win) {
                    matchCount++;
                    break;
                }
            }
        }

        int bestRank = getRank(matchCount + zeroCount);
        int worstRank = getRank(matchCount);

        return new int[]{bestRank, worstRank};
    }

    private int getRank(int match) {
        if (match >= 6) return 1;
        if (match == 5) return 2;
        if (match == 4) return 3;
        if (match == 3) return 4;
        if (match == 2) return 5;
        return 6;
    }
}