import java.io.*;
import java.util.*;

public class Solution {
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                // 0: union 1: intersection
                int operation = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(operation == 0) union(a, b);
                else {
                    if(find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) { // Only merge if roots are different
            if(rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if(rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    private static int find(int a) {
        if(parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}