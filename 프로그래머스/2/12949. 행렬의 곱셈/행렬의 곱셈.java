class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int m = 0; m < arr1.length; m++) {
            for(int n = 0; n < arr2[0].length; n++){
                for(int k = 0; k < arr1[0].length; k++){
                    answer[m][n] += (arr1[m][k] * arr2[k][n]);
                }
            }
        }
        
        return answer;
    }
}