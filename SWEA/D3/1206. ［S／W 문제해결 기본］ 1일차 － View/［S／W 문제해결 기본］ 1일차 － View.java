
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int N = sc.nextInt();
            int[] buildings = new int[N];
            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            int viewPoints = 0;

            for (int b = 2; b < N - 2; b++) {
                int left1 = buildings[b - 2];
                int left2 = buildings[b - 1];
                int right1 = buildings[b + 1];
                int right2 = buildings[b + 2];

                int current = buildings[b];

                int maxAround = Math.max(Math.max(left1, left2), Math.max(right1, right2));

                if (current > maxAround) {
                    viewPoints += current - maxAround;
                }
            }

            System.out.println("#" + (t + 1) + " " + viewPoints);
        }

        sc.close();
    }
}