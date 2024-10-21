import java.io.*;
import java.util.*;

public class Main {
    static int N, highest, maxCount;
    static int[][] land;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        land = new int[N][N];


        highest = -1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(highest, land[i][j]);
            }
        }


        maxCount = 0;
        for(int h = 0; h <= highest; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j] || land[i][j] <= h) continue;
                    dfs(i, j, h);
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }



        System.out.println(maxCount);



    }

    static void dfs(int i, int j, int h) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (check(nr, nc) && land[nr][nc] > h && !visited[nr][nc]) {
                dfs(nr, nc, h);
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}