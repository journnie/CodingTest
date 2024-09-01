import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int ingredientNum, limitCalories;
    static int[] scores;
    static int[] calories;
    static int bestHamburger;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredientNum = Integer.parseInt(st.nextToken());
            limitCalories = Integer.parseInt(st.nextToken());

            scores = new int[ingredientNum];
            calories = new int[ingredientNum];

            for (int i = 0; i < ingredientNum; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            bestHamburger = 0;  // bestHamburger 초기화
            findBestHamburger(0, 0, 0);
            System.out.printf("#%d %d\n", t, bestHamburger);
        }
    }

    static void findBestHamburger(int index, int currentHamburger, int currentCalories) {
        if (currentCalories > limitCalories) {
            return;  // 칼로리 제한 초과 시 종료
        }

        if (index == ingredientNum) {
            bestHamburger = Math.max(bestHamburger, currentHamburger);
            return;
        }

        // 현재 재료를 선택하지 않는 경우
        findBestHamburger(index + 1, currentHamburger, currentCalories);

        // 현재 재료를 선택하는 경우
        findBestHamburger(index + 1, currentHamburger + scores[index], currentCalories + calories[index]);
    }
}