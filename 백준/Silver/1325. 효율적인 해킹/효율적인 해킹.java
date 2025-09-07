import java.util.*;
import java.io.*;

public class Main {


    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<Integer>[] arr;
    static boolean [] check;
    static int[] check_v;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        
        
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        
        check_v = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        
        
        for(int i=1; i<=N; i++){
            check = new boolean[N+1];
            bfs(i);
        }
        
        
        int max = Integer.MIN_VALUE;
        for (int i : check_v) {
            if(i > max){
                max = i;
            }
        }
        
        for(int i=1; i<=N; i++){
            if(check_v[i] == max){
                System.out.print(i + " ");
            }
        }

        
        bw.flush();
        bw.close();


    }
    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (Integer i : arr[now]) {
                if(!check[i]){
                    check_v[i] ++;
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }
}