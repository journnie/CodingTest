import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = 100;
        int T = 10;

        for(int t = 0; t <T; t++) {
            int testCase = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[N][N];

            // 배열 만들면서 행 최대합 구하기
            int maxRowSum = 0;
            int rowSum = 0;
            for(int row = 0; row < N; row++){
                rowSum = 0;
                String[] rowStr = br.readLine().trim().split(" ");
                for(int col = 0; col <N; col++){
                    arr[row][col] = Integer.parseInt(rowStr[col]);
                    rowSum += arr[row][col];
                }
                maxRowSum = Math.max(maxRowSum, rowSum);
            }

            // 열 최대합 구하기
            int maxColSum = 0;
            int colSum = 0;
            for(int col = 0; col<N; col++){
                colSum = 0;
                for(int row = 0; row < N; row++){
                    colSum += arr[row][col];
                }
                maxColSum = Math.max(maxColSum, colSum);
            }

            // 대각선 최대합 구하기
            int maxDiagSum = 0;
            int diagSum = 0;
            int inverseDiageSum = 0;
            for(int row = 0; row <N; row++){
                diagSum += arr[row][row];
                inverseDiageSum += arr[row][N-1-row];
            }
            maxDiagSum = Math.max(inverseDiageSum, diagSum);

            int answer = Math.max(Math.max(maxColSum, maxRowSum), maxDiagSum);

            System.out.printf("#%d %d\n", testCase, answer);
        }
    }
}
