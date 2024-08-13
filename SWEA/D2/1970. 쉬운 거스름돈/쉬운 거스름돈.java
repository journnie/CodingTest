import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(Integer.toString(t)).append("\n");
            int cash = Integer.parseInt(br.readLine());
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

            while (cash >= 10) {
                for(int m = 0; m < money.length; m++) {
                    int change = cash/money[m];
                    sb.append(change).append(" ");
                    cash = cash - money[m]*change;
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
