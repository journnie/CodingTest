import java.util.*;

class Solution {
    static boolean[] visited;
    
    public static int solution(int n, int[][] wires) {
        int[][] towers = new int[n + 1][n + 1];

        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];
            towers[v1][v2] = towers[v2][v1] = 1;
        }

        int minDifference = Integer.MAX_VALUE;

        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];

            towers[v1][v2] = towers[v2][v1] = 0;

            visited = new boolean[n + 1];

            // 두 네트워크의 노드 개수를 BFS로 계산
            int size1 = bfs(v1, towers);
            int size2 = bfs(v2, towers);


            minDifference = Math.min(minDifference, Math.abs(size1 - size2));

            towers[v1][v2] = towers[v2][v1] = 1;
        }

        return minDifference;
    }

    public static int bfs(int start, int[][] towers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int count = 1;  

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i < towers.length; i++) {
                if (towers[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++; 
                }
            }
        }

        return count;
    }
}