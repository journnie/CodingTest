import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] tempStr = br.readLine().split(" ");

        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(tempStr[i]);
        }

        int currTempSum = 0;
        // first window
        for (int i = 0; i < K; i++) {
            currTempSum += temp[i];
        }

        int maxTempSum = currTempSum;

        for(int endDay = K; endDay < N; endDay++) {
            currTempSum += temp[endDay] - temp[endDay - K];
            maxTempSum = Math.max(maxTempSum, currTempSum);
        }

        System.out.println(maxTempSum);

    }
}
