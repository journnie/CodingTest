import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int papers = Integer.parseInt(br.readLine().trim());
        int[][] graphPaper = new int[1001][1001];
        int[] paperArea = new int[papers+1];
        for(int paper = 1; paper <= papers; paper++) {
            String[] widthsHeights = br.readLine().trim().split(" ");
            int x0 = Integer.parseInt(widthsHeights[0]);
            int y0 = Integer.parseInt(widthsHeights[1]);
            int width = Integer.parseInt(widthsHeights[2]);
            int height = Integer.parseInt(widthsHeights[3]);
            for(int i = x0; i <= x0 + width-1; i++) {
                for(int j = y0; j <= y0 + height-1; j++) {
                    if(graphPaper[i][j] != 0) paperArea[graphPaper[i][j]]--;
                    graphPaper[i][j] = paper;
                    paperArea[paper]++;
                }
            }
        }
        for(int area = 1; area < paperArea.length; area++) {
            System.out.println(paperArea[area]);
        }

    }
}
