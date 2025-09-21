import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] students = {
                            {1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                        };
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int s = 0; s < students.length; s++){
                if(answers[i] == students[s][i%students[s].length]){
                    scores[s]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> topStudent = new ArrayList<>();
        
        for (int s = 0; s < scores.length; s++) {
            if(scores[s] == maxScore) topStudent.add(s+1);
        }
        return topStudent.stream().mapToInt(Integer::intValue).toArray();
    }
}