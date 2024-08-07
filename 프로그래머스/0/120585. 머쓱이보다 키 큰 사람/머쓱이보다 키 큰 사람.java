class Solution {
    public int solution(int[] array, int height) {
        int count = 0; 
        for (int num : array) {
            if (num > height) {
                count++;
            }
        }
        
        return count;
    }
}