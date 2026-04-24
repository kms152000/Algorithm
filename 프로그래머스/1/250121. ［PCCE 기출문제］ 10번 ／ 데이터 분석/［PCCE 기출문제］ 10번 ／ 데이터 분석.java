import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);

        List<int[]> list = new ArrayList<>();

        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }

        Collections.sort(list, (a, b) -> a[sortIdx] - b[sortIdx]);

        int[][] answer = new int[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private int getIndex(String s) {
        if (s.equals("code")) return 0;
        if (s.equals("date")) return 1;
        if (s.equals("maximum")) return 2;
        return 3;
    }
}