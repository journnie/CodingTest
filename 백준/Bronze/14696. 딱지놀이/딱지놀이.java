import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rounds = Integer.parseInt(br.readLine().trim());

        for (int round = 0; round < rounds; round++) {
            int[] shapesA = readShapes(br);
            int[] shapesB = readShapes(br);
            System.out.println(getRoundResult(shapesA, shapesB));
        }
    }

    private static int[] readShapes(BufferedReader br) throws IOException {
        String[] shapesStr = br.readLine().trim().split(" ");
        int[] shapes = new int[5];
        int counts = Integer.parseInt(shapesStr[0]);
        for(int count = 1; count <= counts; count++) {
            int shape = Integer.parseInt(shapesStr[count]);
            shapes[shape]++;
        }
        return shapes;
    }

    private static char getRoundResult(int[] shapesA, int[] shapesB) {
        for(int shape = 4; shape > 0; shape--) {
            if(shapesA[shape] > shapesB[shape]) return 'A';
            if(shapesA[shape] < shapesB[shape]) return 'B';
        }
        return 'D';
    }
}