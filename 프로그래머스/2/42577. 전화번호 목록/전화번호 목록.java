import java.util.*;

public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String prefix = phone_book[i];
            String next = phone_book[i + 1];

            if (isPrefix(prefix, next)) return false; 
        }
        return true;  
    }

    private boolean isPrefix(String prefix, String num) {
        if (prefix.length() > num.length()) return false;

        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != num.charAt(i)) {
                return false;  
            }
        }
        return true; 
    }
}