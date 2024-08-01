class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int M = arr1.length;
        int N = arr1[0].length;
        int P = arr2[0].length;

        int[][] answer = new int[M][P];
        for(int i = 0; i < M; i++){
            for(int k = 0; k < P; k++){
                for(int j = 0; j < N; j++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }
}