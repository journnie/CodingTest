import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, result;
    static int[][] maze;
    static int[] start = new int[2];
    static int[] end = new int[2];
    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = 10;
        for(int t = 1; t <= T; t++) {
            int testCase = Integer.parseInt(br.readLine());
            N = 16;
            maze = new int[N][N];
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if(line.charAt(j) == '2') start = new int[]{i, j};
                    if(line.charAt(j) == '3') end = new int[]{i, j};
                }
            }

            result = 0;
            bfs(start[0], start[1]);
            System.out.printf("#%d %d\n", t, result);
        }

    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for(int d = 0; d < 4; d++) {
                int newRow = curRow + dr[d];
                int newCol = curCol + dc[d];
                if(newRow<0 || newRow>=N || newCol<0 || newCol>=N) continue;
                if(maze[newRow][newCol] == 1) continue;
                if(maze[newRow][newCol] == 3) {
                    result = 1;
                    return;
                }
                maze[newRow][newCol] = 1;
                q.add(new int[]{newRow, newCol});

            }
        }

    }
}
