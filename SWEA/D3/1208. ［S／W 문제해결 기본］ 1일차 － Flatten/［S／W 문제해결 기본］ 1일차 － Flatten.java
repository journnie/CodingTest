import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t = 1; t <= 10; t++) {
            
            int dumpCnt = Integer.parseInt(br.readLine());
            
            int[] boxes = new int[100];
            
            String[] boxRow = br.readLine().split(" ");
            for(int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(boxRow[i]);
            }

            for(int dump = 0; dump < dumpCnt; dump++) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[boxes.length - 1]--;
            }
            Arrays.sort(boxes);
            int diff = boxes[boxes.length - 1] - boxes[0];
            System.out.printf("#%d %d\n", t, diff);
        }
    }
}
