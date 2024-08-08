import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static char[] openParenthesis = {'(', '{', '[', '<'};
    static char[] closeParenthesis = {')', '}', ']', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < 10; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String parenthesis = br.readLine().trim();

            int answer = checkParenthesis(parenthesis)? 1: 0;
            sb.append(String.format("#%d %d\n", t+1, answer));
        }
        System.out.println(sb);
    }
    static boolean checkParenthesis(String parenthesis) {
        Stack<Integer> stack = new Stack<>();

        for(char p : parenthesis.toCharArray()) {
            for(int openP = 0; openP < openParenthesis.length; openP++) {
                if(p == openParenthesis[openP]) {stack.push(openP);}
            }

            for(int closeP = 0; closeP < closeParenthesis.length; closeP++) {
                if(p == closeParenthesis[closeP]) {
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != closeP) {return false;}
                }
            }
        }
        return stack.isEmpty();
    }
}
