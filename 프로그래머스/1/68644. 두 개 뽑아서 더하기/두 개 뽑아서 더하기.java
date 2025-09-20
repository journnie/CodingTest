import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> answer = new HashSet<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++){
                answer.add(numbers[i]+numbers[j]);
            }
        }
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}