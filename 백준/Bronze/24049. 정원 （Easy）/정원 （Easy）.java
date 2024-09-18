import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] garden;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        garden = new int[R+1][C+1];

        st = new StringTokenizer(br.readLine());
        for(int r = 0; r < R; r++) garden[r+1][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int c = 0; c < C; c++) garden[0][c+1] = Integer.parseInt(st.nextToken());


        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                if(garden[r-1][c] == garden[r][c-1]) garden[r][c] = 0;
                else garden[r][c] = 1;
            }
        }

        System.out.println(garden[R][C]);


    }

}
