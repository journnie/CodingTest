import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 만들기
        maze = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j-1) - '0';
            }
        }

        bfs();
        int moves = maze[N][M];
        System.out.println(moves);

    }

    static Queue<int[]> queue = new LinkedList<>();
    static void bfs() {
        queue.add(new int[]{1, 1});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];

            for(int d = 0; d < 4; d++) {
                int newR = curR + dr[d];
                int newC = curC + dc[d];
                if(newR > 0 && newR <= N && newC > 0 && newC <= M) {
                    if(maze[newR][newC] == 1) {
                        queue.add(new int[]{newR, newC});
                        maze[newR][newC] += maze[curR][curC];
                    }
                }
            }
        }

    }
}