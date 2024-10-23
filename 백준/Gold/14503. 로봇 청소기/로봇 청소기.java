import java.io.*;
import java.util.*;

class Pointer {
    int r, c, d;

    public Pointer(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

public class Main {
    static int N, M, cleaned;
    static int[][] room;

    // 북, 동, 남, 서
    static int[][] direction = {
        {-1, 0},  // 북
        {0, 1},   // 동
        {1, 0},   // 남
        {0, -1}   // 서
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        Pointer start = new Pointer(
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()),  
            Integer.parseInt(st.nextToken())  
        );

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                room[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        cleaned = 0;  
        dfs(start);  
        System.out.println(cleaned);  
    }

    static void dfs(Pointer point) {
        // 1. 현재 위치 청소
        if (room[point.r][point.c] == 0) {
            room[point.r][point.c] = 2;  // 청소 완료 표시
            cleaned++;  // 청소한 칸 수 증가
        }

        // 2. 4방향 검사
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            // 반시계 방향 회전
            point.d = (point.d + 3) % 4;
            int nr = point.r + direction[point.d][0];
            int nc = point.c + direction[point.d][1];

            // 청소할 수 있는 칸으로 이동
            if (check(nr, nc) && room[nr][nc] == 0) {
                dfs(new Pointer(nr, nc, point.d)); 
                moved = true;
                break;
            }
        }

        // 3. 네 방향 모두 청소가 되어있거나 벽인 경우 후진
        if (!moved) {
            int backDirection = (point.d + 2) % 4;  // 후진 방향 계산
            int br = point.r + direction[backDirection][0];
            int bc = point.c + direction[backDirection][1];

            // 후진할 수 있으면 후진
            if (check(br, bc) && room[br][bc] != 1) {
                dfs(new Pointer(br, bc, point.d));  // 방향 유지한 채 후진
            }
        }
    }

    // 범위 체크 메서드
    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}