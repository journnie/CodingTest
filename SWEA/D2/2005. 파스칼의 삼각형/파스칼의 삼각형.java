import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] pascalTriangle = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < i+1; j++) {
                    if(i > 1 && j >= 1) pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
                    else pascalTriangle[i][j] = 1;
                }
            }
            System.out.println("#"+t);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < i+1; j++) {
                    System.out.print(pascalTriangle[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
