import java.util.*;
import java.io.*;

public class Solution {
    static int N, maxBlocks;
    static int[][] cheese;
    static boolean[][] eaten, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];

            int maxDay = 1;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, cheese[i][j]);
                }
            }

            maxBlocks = 1;
            for(int day = 1; day <= maxDay; day++){
                eaten = new boolean[N][N];
                int blocks = whatsLeft(day);
                maxBlocks = Math.max(maxBlocks, blocks);
            }

            System.out.printf("#%d %d\n",t,maxBlocks);
        }
    }


    // 덩어리 확인하기
    static int whatsLeft(int day){
        int blocks = 0;
        whoAteMyCheese(day);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!eaten[i][j]) {
                    bfs(i, j);
                    blocks++;
                }
            }
        }
        return blocks;
    }

    // 요정이 먹어치우기
    static void whoAteMyCheese(int day){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (cheese[i][j] == day) {
                    cheese[i][j] = 0;
                }
                if(cheese[i][j]==0) eaten[i][j] = true;
            }
        }
    }

    // 가능한 인접 구간 먹은 걸로 치기
    static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        eaten[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            for(int d = 0; d < 4; d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !eaten[nr][nc]){
                    q.add(new int[]{nr, nc});
                    eaten[nr][nc] = true;
                }
            }
        }
    }


}
