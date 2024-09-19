import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 8;

        int onWhite = 0;
        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= N; j++){
                if(i % 2 != 0 && (i*j) % 2 != 0 && line.charAt(j-1) == 'F')
                    onWhite++;
                else if (i % 2 == 0 && (i*j) % (2*i) == 0 && line.charAt(j-1) == 'F')
                    onWhite++;
            }
        }

        System.out.println(onWhite);

    }

}
