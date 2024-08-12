import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Set<Character> set = new HashSet<>();
            int n = 0;

            while (set.size() < 10) {
                n++;
                char[] chars = Integer.toString(n*N).toCharArray();
                for(char c : chars) {
                    set.add(c);
                }
            }

            int answer = n*N;
            System.out.printf("#%d %d\n", t+1, answer);

        }
    }
}
