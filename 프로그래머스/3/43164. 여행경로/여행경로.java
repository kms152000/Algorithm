import java.util.*;

class Solution {
    private boolean[] used;
    private List<String> route;
    
    
    public String[] solution(String[][] tickets) {
       Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        used = new boolean[tickets.length];
        route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", tickets, 0);
        return route.toArray(new String[0]);
    }
    
     private boolean dfs(String cur, String[][] tickets, int cnt) {
        if (cnt == tickets.length) return true;

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, cnt + 1)) return true;
                route.remove(route.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }
}