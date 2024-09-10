import java.io.*;
import java.util.*;

class Worm {
    int x;
    int y;

    public Worm(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int N;
    static long minDistance;
    static Worm[] worms, couple;
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            sb.append("#"+t+" ");

            N = Integer.parseInt(br.readLine());

            worms = new Worm[N];
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                worms[n] = new Worm(x, y);
            }

            isSelected = new boolean[N];
            minDistance = Long.MAX_VALUE;
            couple = new Worm[2];
            onMyWay(0, 0);

            sb.append(minDistance).append("\n");
        }
        System.out.println(sb);

    }

    static void vectorSum() {
        long sumX = 0, sumY = 0;
        for(int i = 0; i < N; i++) {
            if(isSelected[i]) {
                sumX += worms[i].x;
                sumY += worms[i].y;
            }
            else {
                sumX -= worms[i].x;
                sumY -= worms[i].y;
            }
        }
        long vector = sumX*sumX + sumY*sumY;
        minDistance = Math.min(minDistance, vector);
    }

    static void onMyWay(int count, int idx) {
        if(count == N/2) {
            vectorSum();
            return;
        }
        if(idx == N) return;

        isSelected[idx] = true;
        onMyWay(count+1, idx+1);
        isSelected[idx] = false;
        onMyWay(count, idx+1);

    }
}
