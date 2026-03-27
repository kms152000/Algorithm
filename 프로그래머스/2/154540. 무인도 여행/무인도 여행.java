import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    list.add(dfs(maps, visited, i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    private int dfs(String[] maps, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()
                    && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                sum += dfs(maps, visited, nx, ny);
            }
        }

        return sum;
    }
}