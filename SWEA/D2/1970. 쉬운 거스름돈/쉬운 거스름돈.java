import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append("\n");
            int totalChange = Integer.parseInt(br.readLine());
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] dp = new int[money.length];

            int currentChange = totalChange;
            while (currentChange >= 10){
                for (int m = 0; m < money.length; m++) { // 큰 돈부터 시작함
                    if (currentChange < money[m]) continue;
                    int cnt = currentChange/money[m]; // 동전 개수
                    dp[m] = cnt; // 동전 개수 저장
                    currentChange -= money[m] * cnt; // 나머지 개수 구하러 감

                }
            }

            for (int m = 0; m < money.length; m++) {
                sb.append(dp[m]).append(" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
