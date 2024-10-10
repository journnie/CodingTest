import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K, count;
    static int[][] land;
    static List<Integer> houses = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            land = new int[M][N];
            visited = new boolean[M][N];

            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[x][y] = 1;
            }

            count = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j] || land[i][j] != 1) continue;
                    dfs(i, j);
                    count++;
                }
            }

            System.out.println(count);
        }



    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (check(nr, nc) && land[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}