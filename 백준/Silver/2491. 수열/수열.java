import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] numbersStr = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int decreasingCnt = 1;
        int increasingCnt = 1;
        int maxCnt = 1;

        for (int i =1; i < N; i++) {
            if(numbers[i] == numbers[i-1]) {
                decreasingCnt++;
                increasingCnt++;
            }
            else if(numbers[i] < numbers[i-1]) {
                decreasingCnt++;
                increasingCnt = 1;
            }
            else if(numbers[i] > numbers[i-1]) {
                increasingCnt++;
                decreasingCnt = 1;
            }

            maxCnt = Math.max(maxCnt, Math.max(decreasingCnt, increasingCnt));
        }
        System.out.println(maxCnt);
    }
}
