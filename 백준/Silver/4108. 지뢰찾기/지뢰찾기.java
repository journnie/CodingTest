import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] grid;
    // 상좌 상 상우 우 우하 하 좌하 좌
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) break;

            grid = new char[R][C];

            for(int r = 0; r < R; r++) {
                String line = br.readLine();
                for(int c = 0; c < C; c++) {
                    grid[r][c] = line.charAt(c);
                }
            }

            for(int r = 0; r < R; r++) {
                for(int c = 0; c < C; c++) {
                    if(grid[r][c] == '*') sb.append("*");
                    else sb.append(check(r, c));
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);


    }


    static int check(int r, int c) {
        int count = 0;
        for(int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if(grid[nr][nc] == '*') count++;
            }
        }
        return count;
    }

}
