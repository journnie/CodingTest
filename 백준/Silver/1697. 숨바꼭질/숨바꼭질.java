import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];


        int result = bfs();
        System.out.println(result);



    }
    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[N] = true;
        q.offer(new int[] {N, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int current = cur[0];
            int count = cur[1];

            if(current == K) return count;

            // X - 1
            if(current-1 >= 0 && !visited[current-1]) {
                visited[current-1] = true;
                q.offer(new int[] {current - 1, count + 1});
            }
            // X + 1
            if(current+1 <= 100000 && !visited[current+1]) {
                visited[current+1] = true;
                q.offer(new int[] {current + 1, count + 1});
            }
            // X * 2
            if(current * 2 <= 100000 && !visited[current*2]) {
                visited[current*2] = true;
                q.offer(new int[] {current*2, count + 1});
            }

        }
        return -1;
    }


}