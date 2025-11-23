import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        String best = "";
        int maxCount = 0;

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count > maxCount) {
                maxCount = count;
                best = key;
            }
            else if (count == maxCount && key.compareTo(best) < 0) {
                best = key;
            }
        }

        bw.write(best);


        bw.flush();
        br.close();
        bw.close();
    }
}