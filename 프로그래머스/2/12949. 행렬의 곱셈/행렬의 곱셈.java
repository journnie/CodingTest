class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int M = arr1.length;
        int N = arr1[0].length;
        int P = arr2[0].length;
        
        int[][] answer = new int[M][P];
        
        for(int m=0; m<M; m++){
            for(int p=0; p<P; p++){
                for(int n=0; n<N; n++){
                    answer[m][p]+= arr1[m][n] * arr2[n][p];
                }
            }
        }
        
        return answer;
    }
}