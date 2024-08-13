import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] inputList = br.readLine().split(" ");
            int N = Integer.parseInt(inputList[0]);
            int M = Integer.parseInt(inputList[1]);

            String[] strAi = br.readLine().split(" ");
            String[] strBj = br.readLine().split(" ");

            int[] A = new int[strAi.length];
            int[] B = new int[strBj.length];

            int[] shortArr;
            int[] longArr;

            for(int i = 0; i < strAi.length; i++) {
                A[i] = Integer.parseInt(strAi[i]);
            }
            for(int j = 0; j < strBj.length; j++) {
                B[j] = Integer.parseInt(strBj[j]);
            }

            if(strAi.length <= strBj.length) {
                shortArr = A.clone();
                longArr = B.clone();
            } else {
                shortArr = B.clone();
                longArr = A.clone();
            }

            int maxSum = 0;
            for(int i = 0; i <= longArr.length - shortArr.length; i++) {
                int currSum = 0;
                for(int j = 0; j < shortArr.length; j++) {
                    currSum += shortArr[j] * longArr[i+j];
                }
                maxSum = Math.max(maxSum, currSum);
            }

            System.out.printf("#%d %d\n", t, maxSum);
        }
    }
}
