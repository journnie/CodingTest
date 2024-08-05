class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        for(int num:numbers) sum+=num;
        double answer = (double)sum/numbers.length;
        return answer;
    }
}