import java.io.*;
import java.util.*;

public class Main {
    static int N, M, a, b;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int result = dfs(a, 0);
        System.out.println(result);



    }

    static int dfs(int current, int cnt) {
        if(current == b) return cnt;
        visited[current] = true;

        for(int n = 1; n <= N; n++){
            if(visited[n] || graph[current][n]!=1) continue;
            int result = dfs(n, cnt+1);
            if(result != -1) return result;
        }
        return -1;
    }

}