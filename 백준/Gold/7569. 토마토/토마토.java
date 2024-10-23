import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] box;
    static Queue<int[]> q = new ArrayDeque<>();
    // 상, 하, 좌, 우, 위, 아래
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());   
        H = Integer.parseInt(st.nextToken()); 

        box = new int[H][M][N];  

        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    box[h][m][n] = Integer.parseInt(st.nextToken());
                    if (box[h][m][n] == 1) {
                        q.offer(new int[]{h, m, n}); 
                    }
                }
            }
        }

        int result = bfs(); 
        System.out.println(result);
    }

    static int bfs() {
        int days = -1;

        while (!q.isEmpty()) {
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int h = curr[0], r = curr[1], c = curr[2];

                for (int d = 0; d < 6; d++) {
                    int nh = h + dh[d];
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (check(nh, nr, nc) && box[nh][nr][nc] == 0) {
                        box[nh][nr][nc] = 1;  
                        q.offer(new int[]{nh, nr, nc}); 
                    }
                }
            }

            days++;  
        }

        return ripeTomatoes() ? days : -1;
    }

    static boolean check(int h, int r, int c) {
        return h >= 0 && h < H && r >= 0 && r < M && c >= 0 && c < N;
    }

    static boolean ripeTomatoes() {
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (box[h][m][n] == 0) return false;  
                }
            }
        }
        return true; 
    }
}