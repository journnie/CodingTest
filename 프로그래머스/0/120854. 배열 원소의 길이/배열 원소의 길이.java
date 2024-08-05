class Solution {
    public int[] solution(String[] strlist) {
        int[] lengths = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            lengths[i] = strlist[i].length();
        }
        return lengths;
    }
}