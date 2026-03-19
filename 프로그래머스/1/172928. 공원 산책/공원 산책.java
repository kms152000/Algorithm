class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);

            int nx = x;
            int ny = y;
            boolean canMove = true;

            for (int i = 0; i < dist; i++) {
                if (dir == 'E') ny++;
                else if (dir == 'W') ny--;
                else if (dir == 'S') nx++;
                else if (dir == 'N') nx--;

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}