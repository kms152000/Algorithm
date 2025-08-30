import java.io.*;
import java.util.*;

public class Main {
    private static int sumGroup(String s) {
        int sum = 0;
        String[] nums = s.split("\\+");
        for (String num : nums) sum += Integer.parseInt(num);
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expr = br.readLine().trim();
        String[] groups = expr.split("-");

        int result = sumGroup(groups[0]);
        for (int i = 1; i < groups.length; i++) result -= sumGroup(groups[i]);

        bw.write(Integer.toString(result));
        bw.flush();
    }
}
