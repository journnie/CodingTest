import java.io.*;
import java.util.*;

public class Solution {
    static int[] yearlyPlan = new int[13];
    static int day, month, threeMonths, year;
    static int minFee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonths = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= 12; m++)
                yearlyPlan[m] = Integer.parseInt(st.nextToken());

            minFee = year;
            dfs(1, 0);
            System.out.printf("#%d %d\n", t, minFee);
        }
    }

    static void dfs(int m, int fee) {
        if(m > 12) {
            minFee = Math.min(minFee, fee);
            return;
        }

        if(fee > minFee) return;

        // 1day
        dfs(m+1, fee + yearlyPlan[m]*day);

        // 1month
        dfs(m+1, fee + month);

        // 3month
        dfs(m+3, fee + threeMonths);

    }

}
