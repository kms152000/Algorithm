import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                long x = Long.parseLong(st.nextToken());

                if (op == 'I') {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    long key = (x == 1) ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);
                    if (cnt == 1) map.remove(key);
                    else map.put(key, cnt - 1);
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
        }

        System.out.print(sb.toString());
    }
}