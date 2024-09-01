import java.io.*;

public class Solution {
    static int N;
    static int[][] ingredients;
    static int minTaste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            ingredients = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    ingredients[i][j] = Integer.parseInt(s[j]);
                }
            }

            minTaste = Integer.MAX_VALUE;  // 테스트 케이스마다 초기화

            boolean[] selected = new boolean[N];
            combination(0, 0, selected);

            System.out.printf("#%d %d\n", t, minTaste);
        }
    }

    static void combination(int idx, int count, boolean[] selected) {
        // 재료를 두 그룹으로 나눈다
        // 선택된 그룹: A
        // 선택되지 않은 그룹: B
        if (count == N / 2) { // 절반을 다 선택했다면
            calculateDifference(selected); // 맛 차이를 구한다
            return;
        }
        if (idx == N) return; // 인덱스가 가능한 인덱스를 초과한다면 종료

        selected[idx] = true;
        combination(idx + 1, count + 1, selected);
        selected[idx] = false;
        combination(idx + 1, count, selected);
    }

    static void calculateDifference(boolean[] selected) {
        int tasteA = 0, tasteB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 둘 다 그룹 A 재료이거나
                if (selected[i] && selected[j]) tasteA += ingredients[i][j] + ingredients[j][i];
                    // 둘 다 그룹 B 재료일 때
                else if (!selected[i] && !selected[j]) tasteB += ingredients[i][j] + ingredients[j][i];
            }
        }
        minTaste = Math.min(minTaste, Math.abs(tasteA - tasteB));
    }
}