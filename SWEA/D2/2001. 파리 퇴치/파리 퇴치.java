import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[][] flies = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    flies[i][j] = scanner.nextInt();
                }
            }

            int maxFlies = 0;
            for(int i = 0; i < N-M+1; i++){
                for(int j = 0; j < N-M+1; j++){
                    int currentFlies = 0;
                    for(int r = 0; r < M; r++){
                        for(int c = 0; c < M; c++){

                            currentFlies += flies[i+r][j+c];
                        }
                    }
                    maxFlies = Math.max(maxFlies, currentFlies);
                }
            }
            System.out.printf("#%d %d\n", t+1, maxFlies);
        }


    }
}
