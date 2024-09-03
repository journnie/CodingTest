import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            for(int j = 1; j <= m;j++) {
                maze[i][j] = line.charAt(j-1) - '0';
            }
        }

        visited[1][1] = true; //start
        bfs(1, 1);
        System.out.println(maze[n][m]);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int nx = current[0];
            int ny = current[1];

            for(int d=0; d < 4; d++) {
                int nextX = nx + dx[d];
                int nextY = ny + dy[d];

                if(nextX > 0 && nextX <= n && nextY > 0 && nextY <= m) {
                    if(maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[] {nextX, nextY});
                        visited[nextX][nextY]=true;
                        maze[nextX][nextY] = maze[nx][ny]+1;
                    }
                }
            }
        }
    }
}