import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];
        int[] prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int num = 1; num <= N; num++) {
            numbers[num] = Integer.parseInt(st.nextToken());
            prefixSum[num] += prefixSum[num-1] + numbers[num];
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = prefixSum[end] - prefixSum[start-1];
            System.out.println(sum);

        }
    }
}
