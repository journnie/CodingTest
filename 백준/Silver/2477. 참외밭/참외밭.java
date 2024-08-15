import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int melonsPerM2 = Integer.parseInt(br.readLine());

        int[] directions = new int[6];
        int[] lengths = new int[6];

        for(int side = 0; side < 6; side++) {
            String[] directionLength = br.readLine().split(" ");
            directions[side] = Integer.parseInt(directionLength[0]);
            lengths[side] = Integer.parseInt(directionLength[1]);
        }

        int fullWidth = 0;
        int fullHeight = 0;
        int fullWidthIdx = 0;
        int fullHeightIdx = 0;

        for(int side = 0; side < 6; side++) {
            // 1, 2 -> width
            if(directions[side] == 1 || directions[side] == 2) {
                if(lengths[side] > fullWidth){
                    fullWidth = lengths[side];
                    fullWidthIdx = side;
                    continue;
                }
            }

            // 3, 4 -> height
            if(directions[side] == 3 || directions[side] == 4) {
                if(lengths[side] > fullHeight){
                    fullHeight = lengths[side];
                    fullHeightIdx = side;
                    continue;
                }
            }
        }
        int smallWidth = lengths[(fullWidthIdx + 3) % 6];
        int smallHeight = lengths[(fullHeightIdx + 3) % 6];;

        int area = (fullWidth*fullHeight) - (smallWidth*smallHeight);
        int melons = area*melonsPerM2;

        System.out.println(melons);

    }
}
