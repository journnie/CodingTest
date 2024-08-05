class Solution {
    public int solution(int n) {
        int pizza = n/7;
        if((n%7) != 0) pizza++;

        return pizza;
    }
}