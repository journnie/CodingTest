import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> moneyStack = new Stack<>();
            for(int i = 0; i < N; i++) {
                int money = Integer.parseInt(br.readLine());
                if(money == 0) moneyStack.pop();
                else moneyStack.push(money);
            }
            int moneySum = 0;
            while (!moneyStack.isEmpty()) {
                moneySum += moneyStack.pop();
            }

            System.out.printf("#%d %d\n", t, moneySum);
        }

    }
}
