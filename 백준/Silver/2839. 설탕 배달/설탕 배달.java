import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                bw.write(Integer.toString(count));
                bw.flush();
                return;
            }
            N -= 3;
            count++;
        }


        bw.write("-1");
        bw.flush();
    }
}