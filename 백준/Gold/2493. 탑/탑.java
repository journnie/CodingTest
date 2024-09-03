import java.io.*;
import java.util.*;

public class Main {
    static int[] towers;
    static int[] receivingTowers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        towers = new int[N];
        receivingTowers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) receivingTowers[i] = stack.peek()+1;

            stack.push(i);
        }

        for(int t: receivingTowers) {
            sb.append(t).append(" ");
        }
        System.out.println(sb);
    }
}
