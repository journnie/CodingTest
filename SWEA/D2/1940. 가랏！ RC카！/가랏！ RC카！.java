import java.io.*;

public class Solution {
    static int N;
    static int distance;
    static int totalTime;
    static int time, speed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            int speed = 0;
            int distance = 0;
            for(int i = 0; i < N; i++) {
                String[] speedStr = br.readLine().split(" ");
                if(speedStr[0].equals("0")) {
                    distance += speed;
                    continue;
                }

                int a = Integer.parseInt(speedStr[0]);
                int acceleration = Integer.parseInt(speedStr[1]);

                if(a == 1) speed += acceleration;
                if(a == 2) speed -= acceleration;
                if(speed < 0) speed = 0;

                distance += speed;

            }

            System.out.printf("#%d %d\n", t, distance);
        }
    }
}
