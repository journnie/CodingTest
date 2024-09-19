import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] row, column;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        row = new boolean[N+1];
        column = new boolean[M+1];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                if(line.charAt(j) == 'X') {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        int noRow = 0, noColumn = 0;
        for(int i = 0; i < N; i++) if(!row[i]) noRow++;
        for(int i = 0; i < M; i++) if(!column[i]) noColumn++;

        int answer = Math.max(noRow, noColumn);
        System.out.println(answer);

    }

}
