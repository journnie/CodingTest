import java.io.*;
import java.util.*;

public class Main {
    static int[] triangle = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());

            triangle[0] = Integer.parseInt(st.nextToken());
            triangle[1] = Integer.parseInt(st.nextToken());
            triangle[2] = Integer.parseInt(st.nextToken());

            if(triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) break;

            Arrays.sort(triangle);

            String answer = rightTriangle()? "right":"wrong";
            System.out.println(answer);
        }
    }

    static boolean rightTriangle() {
        return triangle[2]*triangle[2] == triangle[1]*triangle[1] + triangle[0]*triangle[0];
    }
}