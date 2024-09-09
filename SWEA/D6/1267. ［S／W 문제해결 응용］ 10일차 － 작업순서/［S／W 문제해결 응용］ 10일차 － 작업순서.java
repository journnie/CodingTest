import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static int[][] adjMatrix;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjMatrix = new int[V+1][V+1];
            degree = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjMatrix[from][to] = 1;
                degree[to]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i < V+1; i++) {
                if(degree[i] == 0) queue.add(i);
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                sb.append(curr).append(" ");

                for (int i = 1; i <= V; i++) {
                    if(adjMatrix[curr][i] == 1) {
                        degree[i]--;
                        if (degree[i] == 0) queue.add(i);
                    }

                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
