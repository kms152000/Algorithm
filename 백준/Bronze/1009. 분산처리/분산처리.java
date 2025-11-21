import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < testCaseCount; t++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int baseNumber = Integer.parseInt(stringTokenizer.nextToken());
            int exponent = Integer.parseInt(stringTokenizer.nextToken());

            int lastDigitBase = baseNumber % 10;

            // 밑의 1의 자리가 0이면 무조건 10번 컴퓨터
            if (lastDigitBase == 0) {
                stringBuilder.append(10).append('\n');
                continue;
            }

            int reducedExponent = exponent % 4;
            if (reducedExponent == 0) {
                reducedExponent = 4;
            }

            int resultLastDigit = 1;
            for (int i = 0; i < reducedExponent; i++) {
                resultLastDigit = (resultLastDigit * lastDigitBase) % 10;
            }

            if (resultLastDigit == 0) {
                resultLastDigit = 10;
            }

            stringBuilder.append(resultLastDigit).append('\n');
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }
}