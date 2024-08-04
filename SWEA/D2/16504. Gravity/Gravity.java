import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine().trim());
            String[] boxesStr = br.readLine().trim().split(" ");
            int[] boxes = new int[n];
            for(int i = 0; i<n; i++){
                boxes[i] = Integer.parseInt(boxesStr[i]);
            }

            int maxDrop = 0;
            for(int box = 0; box < n-1; box++){
                int drop = 0;
                for(int nextBox = box+1; nextBox < n; nextBox++){
                    if(boxes[box] > boxes[nextBox]) drop++;
                }
                maxDrop = Math.max(maxDrop, drop);
            }
            System.out.printf("#%d %d\n", t+1, maxDrop);
        }
    }
}
