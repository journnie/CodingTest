import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];


        int result = bfs();
        if(result == -1) System.out.println("use the stairs");
        else System.out.println(result);



    }
    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[S] = true;
        q.offer(new int[] {S, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int current = cur[0];
            int count = cur[1];

            if(current == G) return count;

            // S - D
            if(current-D >= 1 && !visited[current-D]) {
                visited[current-D] = true;
                q.offer(new int[] {current - D, count + 1});
            }
            // S + U
            if(current+U <= F && !visited[current+U]) {
                visited[current+U] = true;
                q.offer(new int[] {current + U, count + 1});
            }

        }
        return -1;
    }


}