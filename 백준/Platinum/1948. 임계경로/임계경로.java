import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class dNode {
        int e;
        int value;

        dNode(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<dNode>> list = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list.get(S).add(new dNode(E, V));
            reverseList.get(E).add(new dNode(S, V));
            inDegree[E]++;
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue <Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (dNode next : list.get(now)) {
                inDegree[next.e]--;

                result[next.e] = Math.max(result[next.e], result[now] + next.value);
                if (inDegree[next.e] == 0) {
                    queue.offer(next.e);
                }
            }
        }


        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : reverseList.get(now)) {
                // 1분도 쉬지 않는 도로 체크
                if (result[next.e] + next.value == result[now]) {
                    resultCount++;
                    // 이미 방문한 노드 제외로 중복 카운트 방지
                    if (visited[next.e] == false) {
                        visited[next.e] = true;
                        queue.offer(next.e);
                    }
                }
            }
        }

        bw.write(result[end] + "\n" + resultCount);


        bw.flush();
        bw.close();
        br.close();
    }
}