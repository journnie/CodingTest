import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int ingredientCount = Integer.parseInt(st.nextToken());
            int limitCalories = Integer.parseInt(st.nextToken());
            int[][] ingredients = new int[ingredientCount][2];

            for(int i = 0; i < ingredientCount; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[limitCalories+1];
            int maxScore = Integer.MIN_VALUE;


            for(int i = 0; i < ingredientCount; i++) {
                for(int calories = limitCalories; calories > 0; calories--) {
                    int currentScore = ingredients[i][0];
                    int currentCalories = ingredients[i][1];
                    // 제한 칼로리보다 높으면 패스
                    if(currentCalories > calories) continue;
                    dp[calories] = Math.max(dp[calories], dp[calories - currentCalories]+currentScore);
                    maxScore = Math.max(maxScore, dp[calories]);
                }
            }
            System.out.printf("#%d %d\n", t, maxScore);



        }

    }
}
