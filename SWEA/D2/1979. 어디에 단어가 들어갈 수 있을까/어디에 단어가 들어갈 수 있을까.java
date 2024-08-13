import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] numArr = br.readLine().split(" ");
            int N = Integer.parseInt(numArr[0]);
            int K = Integer.parseInt(numArr[1]);

            boolean[][] puzzle = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    if(line[j].equals("1")) puzzle[i][j] = true;
                    else puzzle[i][j] = false;
                }
            }
            // row
            int KinARow = 0;
            for(int row = 0; row < N; row++) {
                int rowCnt = 0;
                for(int col = 0; col < N; col++) {
                    if(puzzle[row][col]) rowCnt++;
                    else {
                        if(rowCnt == K) KinARow++;
                        rowCnt = 0;
                    }
                }
                if(rowCnt == K) KinARow++;
            }

            // row
            int KinCol = 0;
            for(int col = 0; col < N; col++) {
                int colCnt = 0;
                for(int row = 0; row < N; row++) {
                    if(puzzle[row][col]) colCnt++;
                    else {
                        if(colCnt == K) KinCol++;
                        colCnt = 0;
                    }
                }
                if(colCnt == K) KinCol++;
            }
            int answer = KinARow + KinCol;

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
