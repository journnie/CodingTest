import java.io.*;
import java.util.*;

public class Main {
    static int[] rocks;
    static boolean[] visited;
    static int rockNum, count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        rockNum = Integer.parseInt(br.readLine());
        rocks = new int[rockNum+1];
        visited = new boolean[rockNum+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= rockNum; i++){
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        count = 1;
        dfs(start);
        System.out.println(count);


    }

    static void dfs(int start){
        visited[start] = true;

        // go right
        int rightRock = rocks[start] + start;
        boolean isRight = rightRock > 0 && rightRock <= rockNum && !visited[rightRock];
        if(isRight){
            count++;
            dfs(rightRock);
        }

        // go left
        int leftRock = start - rocks[start];
        boolean isLeft = leftRock > 0 && leftRock <= rockNum && !visited[leftRock];
        if(isLeft){
            count++;
            dfs(leftRock);
        }

        return;

    }
}
