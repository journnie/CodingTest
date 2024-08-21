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

            // 가로 회문 탐색
            for (int i = 0; i < N; i++) {
                for (int start = 0; start < N; start++) {
                    for (int end = N - 1; end >= start; end--) {
                        if (isRowPalindrome(text[i], start, end)) {
                            maxPalindromeLength = Math.max(maxPalindromeLength, end - start + 1);
                        }
                    }
                }
            }

            // 세로 회문 탐색
            for (int j = 0; j < N; j++) {
                for (int start = 0; start < N; start++) {
                    for (int end = N - 1; end >= start; end--) {
                        if (isColumnPalindrome(text, j, start, end)) {
                            maxPalindromeLength = Math.max(maxPalindromeLength, end - start + 1);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, maxPalindromeLength);
        }
    }

    // 가로 문자열의 부분 회문 체크
    private static boolean isRowPalindrome(String[] row, int start, int end) {
        while (start < end) {
            if (!row[start].equals(row[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 세로 문자열의 부분 회문 체크
    private static boolean isColumnPalindrome(String[][] text, int col, int start, int end) {
        while (start < end) {
            if (!text[start][col].equals(text[end][col])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}