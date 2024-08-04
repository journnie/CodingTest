import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    // right, down, left, up
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0 ,-1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine().trim());
            int[][] snail = new int[N][N];

            int x=0, y=0, direction=0;
            for(int num = 1; num <= N*N; num++){
                snail[x][y] = num;

                int nx = x+dx[direction];
                int ny = y+dy[direction];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0){
                    direction = (direction+1) % 4;
                    nx = x+dx[direction];
                    ny = y+dy[direction];
                }
                x = nx;
                y = ny;
            }
            System.out.println("#" + (t+1));
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
