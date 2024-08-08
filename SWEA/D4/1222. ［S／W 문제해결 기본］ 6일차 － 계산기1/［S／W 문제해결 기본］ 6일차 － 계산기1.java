import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine().trim();
            int sum = 0;
            for(char c : line.toCharArray()) {
                if('0' <= c && c <= '9') sum += c - '0';
            }
            sb.append(String.format("#%d %d\n", t, sum));
        }
        System.out.println(sb);
    }
}
