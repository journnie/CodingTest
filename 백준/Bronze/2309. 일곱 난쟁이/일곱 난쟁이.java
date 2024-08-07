import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine().trim());
        }
        int sumHeight = 0;
        for(int height:dwarfs) sumHeight += height;

        int fake1Idx = -1;
        int fake2Idx = -1;

        boolean found = false;

        for(int i = 0; i < dwarfs.length; i++) {
            for(int j = i+1; j < dwarfs.length; j++) {
                if(sumHeight -dwarfs[i] - dwarfs[j] == 100) {
                    fake1Idx = i;
                    fake2Idx = j;
                    found = true;
                }
                if(found) break;
            }
            if(found) break;
        }

        int[] realDwarfs = new int[7];
        int idx = 0;
        for(int i = 0; i < dwarfs.length; i++) {
            if(i == fake1Idx || i == fake2Idx) continue;
            realDwarfs[idx++] = dwarfs[i];
        }

        Arrays.sort(realDwarfs);
        for(int dwarf = 0; dwarf < 7; dwarf++) {
            System.out.printf("%d\n", realDwarfs[dwarf]);
        }


    }
}
