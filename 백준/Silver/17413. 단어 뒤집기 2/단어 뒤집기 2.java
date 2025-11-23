import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                int j = i;

                while (s.charAt(j) != '>') {
                    j++;
                }
                j++;
                sb.append(s, i, j);
                i = j - 1;
            }
            else if (c == ' ') {
                sb.append(' ');
            }
            else {
                int j = i;

                while (j < s.length() && s.charAt(j) != '<' && s.charAt(j) != ' ') {
                    j++;
                }
                for (int k = j - 1; k >= i; k--) {
                    sb.append(s.charAt(k));
                }
                i = j - 1;
            }
        }
        bw.write(sb.toString());


        bw.flush();
        br.close();
        bw.close();
    }
}