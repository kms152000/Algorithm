import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            check = new int[V + 1];
            visited = new boolean[V + 1];
            IsEven = true;

            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= V; i++) {
                if (IsEven)
                    DFS(i);
                else
                    break;
            }

            if (IsEven)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        
        bw.flush();
        bw.close();
        br.close();
    }
        
    
    public static void DFS(int node) {
        visited[node] = true;
        
        for (int i : list[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } 
            else if (check[i] == check[node]) {
                    IsEven = false;
                    return;
            }
        }
    }
}