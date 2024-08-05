class Solution {
    public int solution(int[] array) {
        int maxInt = 0;
        for(int num : array) {
            if(num > maxInt) maxInt = num;
        }
        
        int[] count = new int[maxInt + 1];
        
        for(int num : array) {
            count[num]++;
        }
        
        int maxCount = 0;
        int answer = -1;
        boolean isDuplicate = false;
        
        for(int i = 0; i < maxInt + 1; i++) {
            if(count[i] > maxCount) {
                maxCount = count[i];
                answer = i;
                isDuplicate = false;
            } else if(count[i] == maxCount) {
                isDuplicate = true;
            }
        }
        
        if(isDuplicate) {
            return -1;
        }
        
        return answer;
    }
}
    