import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] waterTariffList = br.readLine().split(" ");

            int tariff = waterTariffs(waterTariffList);

            System.out.printf("#%d %d\n", t, tariff);
        }
    }

    public static int waterTariffs(String[] waterTariffList) {
        int P = Integer.parseInt(waterTariffList[0]); // A사 1리터 당 P원
        int Q = Integer.parseInt(waterTariffList[1]); // B사 R리터 이하
        int R = Integer.parseInt(waterTariffList[2]);
        int S = Integer.parseInt(waterTariffList[3]); // R리터 초과분
        int W = Integer.parseInt(waterTariffList[4]); // 물 사용량

        // A사 요금
        int tariffA = P*W;

        // B사 요금
        int tariffB = Q;
        if(W > R) tariffB += S*(W-R);

        return Math.min(tariffA, tariffB);
    }
}
