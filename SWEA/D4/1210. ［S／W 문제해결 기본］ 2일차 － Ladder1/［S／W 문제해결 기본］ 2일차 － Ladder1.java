import java.io.*;

public class Solution {
    static int[][] ladder = new int[100][100];
    // 좌 우
    static int[] dr = {0, 0};
    static int[] dc = {-1, 1};
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {  // 테스트 케이스는 10개로 고정
            int T = Integer.parseInt(br.readLine());

            // 사다리 입력
            for (int row = 0; row < 100; row++) {
                String[] line = br.readLine().split(" ");
                for (int col = 0; col < 100; col++) {
                    ladder[row][col] = Integer.parseInt(line[col]);
                    if (ladder[row][col] == 2) {
                        X = col;  // 도착점(2)의 열 위치를 저장
                    }
                }
            }

            int col = X;
            int row = 99;  // 시작은 사다리의 가장 밑줄
            while (row > 0) {
                // 좌우로 이동할 수 있는지 확인
                if (col > 0 && ladder[row][col - 1] == 1) {  // 왼쪽으로 이동
                    while (col > 0 && ladder[row][col - 1] == 1) {
                        col--;
                    }
                } else if (col < 99 && ladder[row][col + 1] == 1) {  // 오른쪽으로 이동
                    while (col < 99 && ladder[row][col + 1] == 1) {
                        col++;
                    }
                }
                // 위로 이동 (row--)
                row--;
            }

            System.out.printf("#%d %d\n", T, col);  // 시작점의 열 번호 출력
        }
    }
}