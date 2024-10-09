import java.io.*;
import java.util.*;

public class Main {
    static int N, count, house;
    static int[][] map;
    static List<Integer> houses = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고 방문하지 않은 경우
                    house = 0;
                    dfs(i, j);
                    houses.add(house);  // 집의 수를 저장
                    count++; // 단지의 개수 증가
                }
            }
        }

        Collections.sort(houses); // 집의 수를 오름차순으로 정렬

        System.out.println(count);
        for (int h : houses) {
            System.out.println(h);
        }
    }

    static void dfs(int i, int j) {
        house++; // 단지 내 집의 수 증가
        visited[i][j] = true; // 방문 표시

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (check(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}