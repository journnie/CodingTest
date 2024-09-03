
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    static char[] stack;
    static int stackSize;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            String parenthesis = br.readLine();

            stack = new char[N];
            stackSize = 0;

            int availability = isAvailable(parenthesis);

            System.out.printf("#%d %d\n", t, availability);

        }
    }

    static int isAvailable(String parenthesis) {

        for(char c : parenthesis.toCharArray()) {
            if(c == '(' || c == '{' || c == '[' || c == '<') {
                stack[stackSize++] = c;
            }
            else {
                if(stackSize == 0) return 0;
                if(c == ')') {
                     if(stack[stackSize-1] == '(') stack[--stackSize] = 0;
                     else return 0;
                }
                else if(c == '}') {
                    if(stack[stackSize-1] == '{') stack[--stackSize] = 0;
                    else return 0;
                }
                else if(c == ']') {
                    if(stack[stackSize-1] == '[') stack[--stackSize] = 0;
                    else return 0;
                }
                else if(c == '>') {
                    if(stack[stackSize-1] == '<') stack[--stackSize] = 0;
                    else return 0;
                }
            }
        }
        return stackSize == 0 ? 1 : 0;
    }
}
