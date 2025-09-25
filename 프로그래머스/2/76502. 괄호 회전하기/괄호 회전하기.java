import java.util.*;

class Solution {
    public HashMap<Character, Character> pair;

    public int solution(String s) {
        int answer = 0;
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');

        
        String rotated = s;
        for (int i = 0; i < s.length(); i++) {
            if(isValid(rotated)) answer++;
            
            rotated = rotated.substring(1) + rotated.charAt(0);

        }
        
        
        return answer;
    }
    
    private boolean isValid(String s){
        Stack<Character> check = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(!pair.containsKey(ch)){
                check.push(ch);
                continue;
            }

            if(check.isEmpty() || pair.get(ch)!=check.pop()) return false;


        }
        return check.isEmpty();
    }
}