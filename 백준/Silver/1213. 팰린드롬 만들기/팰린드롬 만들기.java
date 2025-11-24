import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }


        int oddCnt = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCnt++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCnt > 1) {
            bw.write("I'm Sorry Hansoo");
            bw.flush();
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char)(i + 'A'));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(left);

        if (oddCnt == 1) {
            result.append(oddChar);
        }
        result.append(left.reverse());
        bw.write(result.toString());
        

        bw.flush();
        br.close();
        bw.close();
    }
}