import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numCnt = new int[10]; // 1~9
        Map<Character, Integer> colorCnt = new HashMap<>();
        colorCnt.put('R', 0);
        colorCnt.put('B', 0);
        colorCnt.put('Y', 0);
        colorCnt.put('G', 0);

        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());

            colorCnt.put(c, colorCnt.get(c) + 1);
            numCnt[n]++;
            nums[i] = n;
        }

        Arrays.sort(nums);
        int maxNum = nums[4];

        boolean isFlush = colorCnt.values().stream().anyMatch(v -> v == 5);

        boolean isStraight = true;
        for (int i = 1; i < 5; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                isStraight = false;
                break;
            }
        }

        int fourKind = -1, threeKind = -1;
        List<Integer> pairs = new ArrayList<>();
        for (int v = 1; v <= 9; v++) {
            if (numCnt[v] == 4) fourKind = v;
            else if (numCnt[v] == 3) threeKind = v;
            else if (numCnt[v] == 2) pairs.add(v);
        }
        Collections.sort(pairs);

        int score;
        if (isFlush && isStraight) {
            score = 900 + maxNum;
        } else if (fourKind != -1) {
            score = 800 + fourKind;
        } else if (threeKind != -1 && pairs.size() == 1) {
            score = 700 + threeKind * 10 + pairs.get(0);
        } else if (isFlush) {
            score = 600 + maxNum;
        } else if (isStraight) {
            score = 500 + maxNum;
        } else if (threeKind != -1) {
            score = 400 + threeKind;
        } else if (pairs.size() == 2) {
            score = 300 + pairs.get(1) * 10 + pairs.get(0);
        } else if (pairs.size() == 1) {
            score = 200 + pairs.get(0);
        } else {
            score = 100 + maxNum;
        }

        bw.write(Integer.toString(score));
        bw.write('\n');
        bw.flush();
        bw.close();
        br.close();
    }
}
