class Solution {
    public int[] solution(int n) {
        int N = n/2 + 1*(n%2);
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = 2*i+1;
        }
        return answer;
    }
}