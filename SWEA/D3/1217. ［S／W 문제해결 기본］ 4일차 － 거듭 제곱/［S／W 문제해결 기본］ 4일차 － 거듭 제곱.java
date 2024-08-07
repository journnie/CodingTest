import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int t = 0; t < 10; t++){
            int tc = scanner.nextInt();
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int answer = square(N, M);


            System.out.printf("#%d %d\n", tc, answer);
        }
    }
    public static int square(int N, int M){
        if(N == 0) return 0;
        if(M == 0) return 1;
        return N * square(N,M-1);
    }
}
