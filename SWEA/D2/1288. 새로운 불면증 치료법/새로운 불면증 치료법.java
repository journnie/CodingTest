import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            sb.append("#").append(t+1).append(" ");
            int N = Integer.parseInt(br.readLine());

            int zeroToNine = 0;
            int count = 0;

            while (!isZeroToNine(zeroToNine)){
                count++;
                for(char c : String.valueOf(N*count).toCharArray()) {
                    zeroToNine |= (1 << (c - '0'));
                }
            }
            sb.append(count*N).append("\n");
        }
        System.out.println(sb);
    }
    public static boolean isZeroToNine(int zeroToNine) {
        return zeroToNine == (1 << 10)-1;
    }
}
