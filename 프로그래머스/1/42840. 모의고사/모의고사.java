import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] students = {{1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            for(int s=0; s<students.length; s++) {
                int[] student = students[s];
                if(student[i%student.length] == answers[i]) scores[s]++;    
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int s=0; s<students.length; s++) {
            if(scores[s]==maxScore) answer.add(s+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}