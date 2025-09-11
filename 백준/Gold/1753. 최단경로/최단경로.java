import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        ArrayList<Edge> list[] = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }


        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(K, 0));
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentVertex = current.vertex;
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for (int i = 0; i < list[currentVertex].size(); i++) {
                Edge tmp = list[currentVertex].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (distance[next] > distance[currentVertex] + value) {
                    distance[next] = distance[currentVertex] + value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }


        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                bw.write(distance[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
        public int compareTo(Edge o) {
            if (this.value > o.value) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}