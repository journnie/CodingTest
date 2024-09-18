import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, count;
    static char[][] grid;
    static LinkedList<int[]> starts;
    // 상좌 상 상우 우 우하 하 좌하 좌
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        count = 0;
        
        // N < 5 -> 걍 안됨
        if(N >= 5) {
            starts = new LinkedList<>();

            grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j);
                    if(line.charAt(j) == 'M') starts.add(new int[]{i, j});
                }
            }

            count = 0;
            for (int[] start : starts)
                findMobis(start);

        }

        System.out.println(count);

    }

    static void findMobis(int[] start) {
        for(int d = 0; d < 8; d++) {
            int x = start[0];
            int y = start[1];
            countMobis(new int[] {x, y}, d, 1);
        }
    }




    static void countMobis(int[] start, int direction, int charIdx) {
        if(charIdx == 5) {
            count++;
            return;
        }
        int nx = start[0] + dr[direction];
        int ny = start[1] + dc[direction];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) return;
        if(grid[nx][ny] != "MOBIS".charAt(charIdx)) return;
        countMobis(new int[] {nx, ny}, direction, charIdx+1);

    }
}
