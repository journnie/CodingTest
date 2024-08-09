import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String expression = br.readLine().trim();
            String postfix = infixToPostfix(expression);
            System.out.printf("#%d %d\n", t, calculate(postfix));
        }

    }

    // 연산자 우선순위
    static Map<Character, Integer> map = new HashMap<>();
    static{
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
    }

    static String infixToPostfix(String expression) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            // if c is a number
            if('0' <= c && c <= '9') postfix += c;
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while(stack.peek() != '(') postfix += stack.pop();
                stack.pop(); // '(' 빼줘야하지 않나..?
            }
            else{
                // '*', '/'
                if(map.get(c) == 2) stack.push(c);
                // '+', '-'
                if(map.get(c) == 1) {
    //                    if(stack.isEmpty()) continue; // 이러고 push로 가나..? 아 근데 while문 안에서 empty될수도 있어서 여기 있음 안댐
    //                    if(stack.peek() == '(') continue; // 이런 경우가 있나? 괄호 연산 안이라면ㅇㅇ
                    while (!stack.isEmpty() &&
                            stack.peek() != '(' &&
                            map.get(c) <= map.get(stack.peek())) {
                        postfix += stack.pop();
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()) postfix += stack.pop();
        return postfix;
    }

    static int calculate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for(char c : postfix.toCharArray()){
            if('0' <= c && c <= '9') stack.push(c - '0');
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                if(c == '+') result = num1 + num2;
                else if(c == '-') result = num1 - num2;
                else if(c == '*') result = num1 * num2;
                else if(c == '/') result = num1 / num2;
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
