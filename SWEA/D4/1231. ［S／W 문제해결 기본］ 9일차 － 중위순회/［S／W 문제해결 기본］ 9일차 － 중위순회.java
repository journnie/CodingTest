import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int left, right;
        char value;   

        public Node(char value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree;
    static StringBuilder sb;

    static void inOrder(int node) {
        if (node == 0) return; 
        inOrder(tree[node].left); 
        sb.append(tree[node].value); 
        inOrder(tree[node].right); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine()); 
            tree = new Node[N + 1]; 

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken()); 
                char value = st.nextToken().charAt(0); 

                int left = 0, right = 0;
                if (st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right = Integer.parseInt(st.nextToken()); 

                tree[node] = new Node(value, left, right); 
            }

            sb = new StringBuilder();
            inOrder(1);
            result.append("#").append(t).append(" ").append(sb.toString()).append("\n");
        }

        System.out.print(result.toString());
    }
}