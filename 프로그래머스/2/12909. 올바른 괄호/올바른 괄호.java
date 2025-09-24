import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> check = new Stack<>();
        
        for(char p:s.toCharArray()) {
            if(p == '(') check.push(p);
            else {
                if(check.isEmpty()) return false;
                check.pop();
                
            }
        }
        
        return check.isEmpty();
    }
}