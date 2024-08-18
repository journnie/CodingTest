import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++){
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int[][] mars = new int[N][M];

            for(int row = 0; row < N; row++){
                String[] rowStr = br.readLine().split(" ");
                for (int col = 0; col < M; col++){
                    mars[row][col] = Integer.parseInt(rowStr[col]);
                }
            }

            int candidate = 0;
            int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

            for(int row = 0; row < N; row++){
                for (int col = 0; col < M; col++){
                    int photospot = 0;
                    int current = mars[row][col];
                    for(int d = 0; d < dRow.length; d++){
                        int nRow = row + dRow[d];
                        int nCol = col + dCol[d];
                        if(0 <= nRow && nRow < N && 0 <= nCol && nCol < M){
                            if(mars[nRow][nCol] < current) photospot++;
                        }
                    }

                    if(photospot >= 4) candidate++;
                }
            }

            System.out.printf("#%d %d\n", t, candidate);

        }

    }
}
