import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char val;
        Node left, right;
        Node(char v) { this.val = v; }
    }

    
    static Node root;
    static Map<Character, Node> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Node parent = map.getOrDefault(p, new Node(p));
            map.put(p, parent);
            if (i == 0) root = parent;

            if (l != '.') {
                Node left = new Node(l);
                parent.left = left;
                map.put(l, left);
            }
            if (r != '.') {
                Node right = new Node(r);
                parent.right = right;
                map.put(r, right);
            }
        }

        preorder(root);
        sb.append('\n');
        inorder(root);
        sb.append('\n');
        postorder(root);

        
        bw.write(sb.toString());
        bw.flush();
    }

    
    static void preorder(Node n) {
        if (n == null) return;
        sb.append(n.val);
        preorder(n.left);
        preorder(n.right);
    }

    
    static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        sb.append(n.val);
        inorder(n.right);
    }

    
    static void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        sb.append(n.val);
    }
}