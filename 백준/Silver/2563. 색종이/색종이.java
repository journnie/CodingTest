import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int papers = Integer.parseInt(br.readLine().trim());
        boolean[][] blankPaper = new boolean[100][100];
        int totalArea = 0;

        for(int paper = 1; paper <= papers; paper++) {
            String[] widthsHeights = br.readLine().trim().split(" ");
            int x0 = Integer.parseInt(widthsHeights[0]);
            int y0 = Integer.parseInt(widthsHeights[1]);
            int width = 10;
            int height = 10;
            for(int x = x0; x <= x0 + width-1; x++) {
                for(int y = y0; y <= y0 + height-1; y++) {
                    if(blankPaper[x][y]) continue; // if true
                    blankPaper[x][y] = true;
                    totalArea++;
                }
            }
        }
        System.out.println(totalArea);

    }
}
