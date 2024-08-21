import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int N = 100;
            String[][] text = new String[N][N];

            for(int i = 0; i < N; i++) {
                String[] textLine = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    text[i][j] = textLine[j];
                }
            }

            int maxPalindromeLength = 1;  // 최소 길이 1

            // 회문 탐색

            for (int base = 0; base < N; base++) {
                for (int start = 0; start < N; start++) {
                    for (int end = N - 1; end >= start; end--) {
                        if (isColumnPalindrome(text, base, start, end)) {
                            maxPalindromeLength = Math.max(maxPalindromeLength, end - start + 1);
                        }
                        if (isRowPalindrome(text, base, start, end)) {
                            maxPalindromeLength = Math.max(maxPalindromeLength, end - start + 1);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, maxPalindromeLength);
        }
    }

    // 가로 문자열의 부분 회문 체크
    private static boolean isRowPalindrome(String[][] text, int base, int start, int end) {
        while (start < end) {
            if (!text[base][start].equals(text[base][end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 세로 문자열의 부분 회문 체크
    private static boolean isColumnPalindrome(String[][] text, int base, int start, int end) {
        while (start < end) {
            if (!text[start][base].equals(text[end][base])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}