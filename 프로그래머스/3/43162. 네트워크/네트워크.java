class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networks = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networks++;
                dfs(i, computers, visited);
            }
        }
        return networks;
    }

    
    private void dfs(int u, int[][] computers, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < computers.length; v++) {
            if (computers[u][v] == 1 && !visited[v]) {
                dfs(v, computers, visited);
            }
        }
    }
}
