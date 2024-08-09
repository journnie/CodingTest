
import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String p = br.readLine();

            Stack<Character> stack = new Stack<Character>();
            int sticks = 0;
            int result = 0;

            for(int i = 0; i < p.length(); i++) {
                char currentP = p.charAt(i);
                if(currentP == '(') {
                    if(i < p.length()-1 && p.charAt(i+1) == ')'){
                        result += sticks;
                        i++;
                    }
                    else {
                        stack.push(currentP);
                        sticks++;
                    }
                }
                else if(currentP == ')') {
                    stack.pop();
                    sticks--;
                    result++;
                }
            }
            System.out.printf("#%d %d\n", t+1,result);
        }


    }
}

