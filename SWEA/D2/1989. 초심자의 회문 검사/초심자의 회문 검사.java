import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static int Palindrome(String word){
        int n = word.length();
        for(int i = 0; i < n/2; i++){
            if (word.charAt(i) != word.charAt(n-1-i)) return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++){
            String word = br.readLine().trim();

            int ans = Palindrome(word);

            System.out.printf("#%d %d\n", t+1, ans);

        }
    }
}
