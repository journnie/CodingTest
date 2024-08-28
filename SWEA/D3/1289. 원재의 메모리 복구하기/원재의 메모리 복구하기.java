import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            char[] memory = br.readLine().toCharArray();
            int N = memory.length;
            int[] reset = new int[N];

            int fixCnt = 0;

            for(int i=0; i < N; i++){
                int bit = memory[i] - '0';
                if(bit == reset[i]) continue;
                for(int j=i; j < N; j++) reset[j] ^= 1;
                fixCnt++;
                if(memory[i] == reset[i]) break;
            }
            System.out.printf("#%d %d\n", t, fixCnt);
        }
    }
}
