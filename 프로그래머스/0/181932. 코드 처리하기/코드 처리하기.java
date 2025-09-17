class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder(code.length());
        int mode = 0;

        for (int idx = 0; idx < code.length(); idx++) {
            char ch = code.charAt(idx);
            if (ch == '1') { mode ^= 1; continue; }

            if (mode == 0 && (idx % 2 == 0)) ret.append(ch);
            else if (mode == 1 && (idx % 2 == 1)) ret.append(ch);
        }
        
        if (ret.toString().isEmpty()) return "EMPTY";
        return ret.toString();
    }
}
