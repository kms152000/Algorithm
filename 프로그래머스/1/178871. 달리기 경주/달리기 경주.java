import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = rankMap.get(calling);
            String frontPlayer = players[idx - 1];
            
            players[idx - 1] = calling;
            players[idx] = frontPlayer;
            
            rankMap.put(calling, idx - 1);
            rankMap.put(frontPlayer, idx);
        }
        
        return players;
    }
}