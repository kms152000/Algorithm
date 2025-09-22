import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] child;
    static boolean[] removed;
    static int leafCount = 0;

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
            
        int N = Integer.parseInt(br.readLine());

        child = new ArrayList[N];
        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) root = i;
            else child[p].add(i);
        }

        
        int del = Integer.parseInt(br.readLine());
        removed = new boolean[N];
        
        if (del == root) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        markDeleted(del);

        dfsCount(root);

        
        bw.write(Integer.toString(leafCount));
        bw.flush();
    }

    
    static void markDeleted(int u) {
        removed[u] = true;
        for (int v : child[u]) if (!removed[v]) markDeleted(v);
    }
    

    static void dfsCount(int u) {
        if (removed[u]) return;
        int validChildren = 0;
        
        for (int v : child[u]) {
            if (!removed[v]) {
                validChildren++;
                dfsCount(v);
            }
        }
        if (validChildren == 0) leafCount++;
    }
}