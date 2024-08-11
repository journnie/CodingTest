import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] graphPaper = new boolean[101][101];
        int totalArea = 0;
        
        for(int paper = 1; paper <= 4; paper++) {
            String[] coordinates = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);
            int x2 = Integer.parseInt(coordinates[2]);
            int y2 = Integer.parseInt(coordinates[3]);
            
            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    if(graphPaper[i][j]) continue;
                    
                    graphPaper[i][j] = true;
                    totalArea++;
                }
            }
        }
        System.out.println(totalArea);
    }
}
