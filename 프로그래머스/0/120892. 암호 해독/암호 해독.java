class Solution {
    public String solution(String cipher, int code) {
        StringBuilder decrypted = new StringBuilder();
        
        for (int i = code - 1; i < cipher.length(); i += code) {
            decrypted.append(cipher.charAt(i));
        }
        
        return decrypted.toString();
    }
}