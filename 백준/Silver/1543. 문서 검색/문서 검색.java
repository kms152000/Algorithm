import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        String word = br.readLine();

        int count = 0;
        int index = 0;


        while(index <= s.length() - word.length()) {
            if(s.startsWith(word, index)) {
                count++;
                index += word.length();
            } else {
                index++;
            }
        }
        bw.write(count + "\n");

        
        bw.flush();
        br.close();
        bw.close();
    }
}