import java.io.*;
import java.util.*;

public class Solution {
    static int[][] neighbours;
    static boolean[] checked;
    static int N;
    static int groups;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            neighbours = new int[N+1][N+1];
            checked = new boolean[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                neighbours[a][b] = neighbours[b][a] = 1;
            }

            groups = 0;
            myNeighbours();

            System.out.printf("#%d %d\n", t, groups);
        }
    }

    static void myNeighbours() {
        for(int person = 1; person <= N; person++) {
            if(!checked[person]) {
                DFS(person);
                groups += 1;
            }
        }
        return;
    }

    static void DFS(int start) {
        checked[start] = true;

        for (int i = 1; i < N+1; i++) {
            if (neighbours[start][i] == 1 && !checked[i]) {
                DFS(i);
            }
        }
    }

}
