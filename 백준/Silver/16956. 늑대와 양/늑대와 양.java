import java.io.*;
import java.util.*;

public class Main {
    static int R, C; 
    static char[][] farm; 
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        farm = new char[R][C];

        // 목장 상태 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = line.charAt(j);
            }
        }

        if (!isSafe()) { 
            System.out.println(0);
        } else {
            buildFence(); 
            System.out.println(1);
            printFarm(); 
        }
    }

    // 양과 늑대가 인접해 있는지 검사
    static boolean isSafe() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (farm[x][y] == 'S') { 
                    for (int d = 0; d < 4; d++) { 
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            if (farm[nx][ny] == 'W') { 
                                return false; 
                            }
                        }
                    }
                }
            }
        }
        return true; 
    }

    // 울타리 설치 함수
    static void buildFence() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (farm[x][y] == 'W') { 
                    for (int d = 0; d < 4; d++) { 
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && farm[nx][ny] == '.') {
                            farm[nx][ny] = 'D'; 
                        }
                    }
                }
            }
        }
    }

    // 목장 상태 출력 함수
    static void printFarm() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(farm[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}