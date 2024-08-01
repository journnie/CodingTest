import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        Set<Integer> sumArr = new HashSet<>();
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                sumArr.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = sumArr.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
