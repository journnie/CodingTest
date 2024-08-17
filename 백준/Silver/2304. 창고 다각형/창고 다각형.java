import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());
       int[] buildings = new int[1001];
       int maxHeight = 0;

       int start = 1000; // L min
       int end = 0; // L max
       int tallestLeft = 0;

       for (int building = 0; building < N; building++) {
           String[] LH = br.readLine().split(" ");
           int L = Integer.parseInt(LH[0]);
           int H = Integer.parseInt(LH[1]);
           buildings[L] = H;

           start = Math.min(start, L);
           end = Math.max(end, L);

           if(H > maxHeight) {
               maxHeight = H;
               tallestLeft = L;
           }

       }

       int area = maxHeight;
       int tallestBeforeMax = 0;

       for(int buildingNo = start; buildingNo < tallestLeft; buildingNo++) {
           int building = buildings[buildingNo];
           if(building > tallestBeforeMax) tallestBeforeMax = building;
           area += tallestBeforeMax;
       }

        int tallestRight = tallestLeft;

       int tallestAfterMax = 0;

        for(int buildingNo = end ; buildingNo > tallestRight; buildingNo--) {
            int building = buildings[buildingNo];
            if(building > tallestAfterMax) tallestAfterMax = building;
            area += tallestAfterMax;
        }
        System.out.println(area);
    }
}
