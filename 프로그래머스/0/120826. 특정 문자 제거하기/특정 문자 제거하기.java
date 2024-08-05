class Solution {
    public String solution(String my_string, String letter) {
        String result = my_string.replace(letter, "");
        return result;
    }
}